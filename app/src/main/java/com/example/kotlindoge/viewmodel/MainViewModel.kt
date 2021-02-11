package com.example.kotlindoge.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.kotlindoge.repo.DogeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
        val callback: Callback<List<String>> = object : Callback<List<String>> {
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

    fun getDoges(count: Int = 10) {
        viewModelScope.launch(Dispatchers.IO) {
            val dogeList = DogeRepo.getDoge(count)
            _doges.postValue(dogeList)
        }

    }

    fun getDogesKt(count: Int = 10) = liveData { emit(DogeRepo.getDoge(count)) }

}