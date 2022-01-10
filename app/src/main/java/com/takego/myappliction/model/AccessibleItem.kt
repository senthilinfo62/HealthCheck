package com.takego.myappliction.model

import com.google.gson.annotations.SerializedName

data class AccessibleItem(

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("api")
	val api: String,

	@field:SerializedName("status")
	val status: Int
)