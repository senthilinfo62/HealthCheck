package com.takego.myappliction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.takego.myappliction.databinding.ActivityMainBinding
import com.takego.myappliction.repository.MainRepository
import com.takego.myappliction.service.RetrofitService
import com.takego.myappliction.viewModel.MainViewModel
import com.takego.myappliction.viewModel.MyViewModelFactory


class MainActivity : AppCompatActivity() {
    lateinit var  binding : ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val TAG = "MainActivity"
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )

        binding.recyclerView.adapter = adapter

        viewModel.DataList.observe(this, Observer {
            Log.d(TAG, "onCreate: ${it.data.health}")
            adapter.setHealthList(it.data.health,this)
        })

        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "OnERROR: $it")
        })
        viewModel.getAllData()
    }
}