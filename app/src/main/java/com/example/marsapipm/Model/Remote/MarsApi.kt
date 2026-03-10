package com.example.marsapipm.Model.Remote

import retrofit2.Response
import retrofit2.http.GET


interface MarsApi {


    @GET ("realestate")
    suspend fun  fetchMarsDataCoroutines(): Response<List<MarsRealState>>
}