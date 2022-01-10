package com.takego.myappliction.model

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("health")
	val health: List<HealthItem>,

	@field:SerializedName("message")
	val message: String
)