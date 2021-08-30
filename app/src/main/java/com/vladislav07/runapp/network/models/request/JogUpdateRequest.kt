package com.vladislav07.runapp.network.models.request

import com.google.gson.annotations.SerializedName

data class JogUpdateRequest(
    @SerializedName("jog_id") val id: Int,
    @SerializedName("user_id") val userId: String,
    @SerializedName("distance") val distance: Float,
    @SerializedName("time") val time: Int,
    @SerializedName("date") val date: String
)