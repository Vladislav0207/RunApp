package com.vladislav07.runapp.ui.models

import java.io.Serializable

data class JogUI(
    val id: Int = 0,
    val userId: String = "",
    val distance: Double,
    val time: Int,
    val date: String,
    val speed:Double = 0.0
) : Serializable