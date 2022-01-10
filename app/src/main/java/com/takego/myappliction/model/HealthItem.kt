package com.takego.myappliction.model

import com.google.gson.annotations.SerializedName

data class HealthItem(

	@field:SerializedName("accessible")
	val accessible: List<AccessibleItem>,

	@field:SerializedName("name")
	val name: String
)