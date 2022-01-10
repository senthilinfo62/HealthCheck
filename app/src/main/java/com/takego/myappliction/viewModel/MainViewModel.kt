package com.takego.myappliction.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.takego.myappliction.model.Data
import com.takego.myappliction.model.HealthItem
import com.takego.myappliction.model.ResponseModel
import com.takego.myappliction.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val DataList = MutableLiveData<ResponseModel>()


    val errorMessage = MutableLiveData<String>()

    fun getAllData() {

        val response = repository.getAllData()
        response.enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                DataList.postValue(response.body())
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}







