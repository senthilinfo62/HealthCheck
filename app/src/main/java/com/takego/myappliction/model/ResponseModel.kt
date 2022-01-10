package com.takego.myappliction.model

import com.google.gson.annotations.SerializedName

data class ResponseModel(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("statusCode")
	val statusCode: Int
)