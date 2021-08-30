package com.vladislav07.runapp.network.models.response

import com.google.gson.annotations.SerializedName

data class JogResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("user_id") val userId: String,
    @SerializedName("distance") val distance: Double,
    @SerializedName("time") val time: Int,
    @SerializedName("date") val date: String
)
