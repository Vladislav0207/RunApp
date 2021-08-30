package com.vladislav07.runapp.ui.models

data class StatisticsUI(
    val weekNumber: Int,
    val firstDate : String,
    val lastDate : String,
    val avTime: Int,
    val avDistance : Double,
    val avSpeed : Double
)
