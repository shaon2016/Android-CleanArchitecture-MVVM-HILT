package com.lastblade.androidarchitecturewithhilt.data.remote

import com.lastblade.androidarchitecturewithhilt.data.model.User
import com.ujala.dukaan.data.remote.ApiService
import com.ujala.dukaan.data.remote.RetrofitBaseDataSource
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response

class ApiHelper(private val apiService: ApiService) : RetrofitBaseDataSource() {

    //call type
    private val CALL_TYPE_GET = "get"
    private val CALL_TYPE_POST = "post"

    private suspend fun <T> getApiCall(
        type: String,
        path: String,
        hashMap: Map<String, Any>,
        multiMartHashMap: List<MultipartBody.Part>? = null
    ): Response<T> {
        return when (type) {
            CALL_TYPE_GET -> {
                apiService.getRequest(path, hashMap as Map<String, String>)
            }
            CALL_TYPE_POST -> {
                apiService.postRequest(path, hashMap as Map<String, String>)
            }
            else -> {
                apiService.sendDocuments(
                    path,
                    hashMap as Map<String, RequestBody>,
                    multiMartHashMap!!
                )
            }
        }
    }

    suspend fun createUser(mobileNo: String) = getResult(type = User::class.java) {
        val hashMap = HashMap<String, String>()
        hashMap["phone"] = mobileNo

        getApiCall(CALL_TYPE_POST, "users", hashMap)
    }



}