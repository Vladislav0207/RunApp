package com.vladislav07.runapp.network.models.response

import com.google.gson.annotations.SerializedName

data class JogsAndUserResponse(
    val response: JogsAndUserNetwork
)

data class JogsAndUserNetwork(
    @SerializedName("jogs") val jogs : List<JogResponse>,
    @SerializedName("users") val user: List<UserResponse>
)


