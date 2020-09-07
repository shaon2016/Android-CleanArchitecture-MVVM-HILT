package com.lastblade.androidarchitecturewithhilt.data.remote

import com.lastblade.androidarchitecturewithhilt.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("my_json")
    suspend fun getUsers(): Response<List<User>>
}