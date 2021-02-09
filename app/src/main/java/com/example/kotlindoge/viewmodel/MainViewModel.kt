package com.example.kotlindoge.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlindoge.repo.DogeRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    companion object {
        private const val TAG = "MainViewModel"
    }

    private val _doges = MutableLiveData<List<String>>()

    val doges: LiveData<List<String>>
        get() = _doges

    init {
        val callback : Callback<List<String>> = object : Callback<List<String>> {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                _doges.value = response.body()
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                Log.e(TAG, "onFailure: ", t)
            }
        }

        DogeRepo.dogeService.getDoge(10)
            .enqueue(callback)
    }
}