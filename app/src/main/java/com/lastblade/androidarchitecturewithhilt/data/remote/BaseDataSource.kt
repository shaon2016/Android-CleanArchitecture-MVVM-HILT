package com.lastblade.androidarchitecturewithhilt.data.remote

import com.lastblade.androidarchitecturewithhilt.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import java.io.IOException

abstract class BaseDataSource {

    protected suspend inline fun <T : Any> getResult(crossinline call: suspend () -> Response<T>): Flow<Result<T>> {
        return flow {
            emit(Result.InProgress(true))

            val response = call()

            emit(
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        Result.Success(body)
                    } else {
                        Result.UnknownError(null)
                    }
                } else {
                    Result.ApiError(response.errorBody()!!, response.code())
                }
            )

            emit(Result.InProgress(false))
        }.catch { e ->
            emit(Result.InProgress(false))
            emit(
                if (e is IOException) {
                    Result.NetworkError(e)
                } else {
                    Result.UnknownError(e)
                }
            )
        }.flowOn(Dispatchers.IO)

    }
}