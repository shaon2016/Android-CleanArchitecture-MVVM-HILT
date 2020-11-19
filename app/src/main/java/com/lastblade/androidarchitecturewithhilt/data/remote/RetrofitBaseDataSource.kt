package com.ujala.dukaan.data.remote

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException
import java.lang.reflect.Type
import com.lastblade.androidarchitecturewithhilt.util.Result
import kotlinx.coroutines.flow.flowOn

abstract class RetrofitBaseDataSource {

    protected suspend inline fun <T : Any> getResult(
        type: Type,
        crossinline call: suspend () -> Response<T>
    ): Flow<Result<T>> {
        return flow {
            emit(Result.InProgress(true))

            val response = call()

            emit(
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        Result.Success(body, type)
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