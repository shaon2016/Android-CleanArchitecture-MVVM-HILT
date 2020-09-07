package com.lastblade.androidarchitecturewithhilt.util

import okhttp3.ResponseBody
import java.io.IOException

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()

    data class ApiError(val errorBody: ResponseBody, val code: Int) : Result<Nothing>()

    data class NetworkError(val error: IOException) : Result<Nothing>()

    data class UnknownError(val exception: Exception?) : Result<Nothing>()
}