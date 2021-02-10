package com.example.kotlindoge.repo

import com.example.kotlindoge.repo.remote.RetrofitInstance


object DogeRepo {

    val dogeService = RetrofitInstance.dogeService


    suspend fun getDoge(count: Int) : List<String> {
        return RetrofitInstance.dogeService.getDogeCoroutines(count)
    }
}