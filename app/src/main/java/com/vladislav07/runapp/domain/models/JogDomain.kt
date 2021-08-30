package com.vladislav07.runapp.domain.models

data class JogDomain(
    val id: Int,
    val userId: String,
    val distance: Double,
    val time: Int,
    val date: String,
    var speed: Double = 0.0
)
