package com.vladislav07.runapp.domain.models

data class UserDomain(
    val id: String,
    val email: String,
    val phone: String,
    val role: String,
    val firstName: String,
    val lastName: String
)
