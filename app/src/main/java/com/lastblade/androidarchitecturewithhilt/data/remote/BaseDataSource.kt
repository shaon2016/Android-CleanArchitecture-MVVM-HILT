package com.lastblade.androidarchitecturewithhilt.data.remote

import com.lastblade.androidarchitecturewithhilt.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.IOException

abstract class BaseDataSource {

    protected suspend inline fun <T : Any> getResult(crossinline call: suspend () -> Response<T>): Result<T> {
        return withContext(Dispatchers.IO) {
            try {
                val response = call()

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

            } catch (e: Exception) {
                if (e is IOException) {
                    Result.NetworkError(e)
                } else {
                    Result.UnknownError(e)
                }
            }
        }
    }
}