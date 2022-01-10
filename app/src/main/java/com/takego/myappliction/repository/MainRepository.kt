package com.takego.myappliction.repository

import com.takego.myappliction.service.RetrofitService



class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllData() = retrofitService.getAllData()
}