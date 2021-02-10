package com.example.kotlindoge.repo.remote

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DogeService {
    /**
     * Implementation using native retrofit multithreading mechanism
     */
    @GET("shibes")
    fun getDoge(
        @Query("count") count: Int
    ): Call<List<String>>


    /**
     * Implementation using kotlin coroutines multithreading mechanism
     *
     * suspend is a keyword that lets the compiler know this is a coroutine function
     */
    @GET("shibes")
    suspend fun getDogeCoroutines(
        @Query("count") count: Int
    ): List<String>

    /**
     * If i wanted to know about the status code and other call details I can wrap the response
     * object in the retrofit Response Object
     *
     * status code like 200, 400 etc
     */
    @GET("shibes")
    suspend fun getDogeCoroutinesWithResponse(
        @Query("count") count: Int
    ): Response<List<String>>


}