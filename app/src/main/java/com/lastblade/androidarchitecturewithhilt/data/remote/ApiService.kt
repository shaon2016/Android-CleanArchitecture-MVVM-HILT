package com.ujala.dukaan.data.remote

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*
import java.util.HashMap

interface ApiService {

    @FormUrlEncoded
    @POST("{url}")
    suspend fun <T> postRequest(
        @Path(value = "url", encoded = true) path: String,
        @FieldMap hashMap: Map<String, String>
    ): Response<T>

    @GET("{url}")
    suspend fun <T> getRequest(
        @Path(value = "url", encoded = true) path: String,
        @QueryMap hashMap: Map<String, String>
    ): Response<T>

    @Multipart
    @POST("{url}")
    suspend fun <T> sendDocuments(
        @Path(value = "url", encoded = true) path: String,
        @PartMap partMap: Map<String, @JvmSuppressWildcards RequestBody>,
        @Part image: List<@JvmSuppressWildcards MultipartBody.Part>
    ): Response<T>


}