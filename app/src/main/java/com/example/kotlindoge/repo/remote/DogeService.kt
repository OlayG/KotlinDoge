package com.example.kotlindoge.repo.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DogeService {

    @GET("shibes")
    fun getDoge(
        @Query("count") count: Int
    ): Call<List<String>>
}