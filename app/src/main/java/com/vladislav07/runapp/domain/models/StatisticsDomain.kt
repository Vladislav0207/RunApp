package com.vladislav07.runapp.domain.models

data class StatisticsDomain(
    val weekNumber: Int,
    val firstDate : String,
    val lastDate : String,
    val avTime: Int,
    val avDistance : Double,
    val avSpeed : Double
)
