package com.lastblade.androidarchitecturewithhilt.util

import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import java.io.IOException
import java.lang.reflect.Type

sealed class Result<out R> {
    data class Success<T>(val data: T, val type: Type) : Result<T>()

    data class ApiError(val errorBody: ResponseBody, val code: Int) : Result<Nothing>()

    data class NetworkError(val error: IOException) : Result<Nothing>()

    data class UnknownError(val exception: Throwable?) : Result<Nothing>()

    data class InProgress(val isLoading: Boolean) : Result<Nothing>()

}