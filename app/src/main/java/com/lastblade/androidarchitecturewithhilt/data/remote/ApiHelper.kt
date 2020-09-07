package com.lastblade.androidarchitecturewithhilt.data.remote

class ApiHelper(private val apiService: ApiService) : BaseDataSource() {

    suspend fun getUsers() = getResult { apiService.getUsers() }
}