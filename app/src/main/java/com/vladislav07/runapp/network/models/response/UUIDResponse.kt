package com.vladislav07.runapp.network.models.response

import com.google.gson.annotations.SerializedName

data class UUIDResponse(
  val response: UUID
)
data class UUID(
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("token_type") val tokenType: String,
    @SerializedName("user") val userResponse: UserResponse
)