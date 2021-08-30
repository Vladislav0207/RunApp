package com.vladislav07.runapp.ui.mapper

import com.vladislav07.runapp.domain.models.FeedbackDomain
import com.vladislav07.runapp.domain.models.JogDomain
import com.vladislav07.runapp.domain.models.StatisticsDomain
import com.vladislav07.runapp.domain.models.UserDomain
import com.vladislav07.runapp.ui.models.FeedbackUI
import com.vladislav07.runapp.ui.models.JogUI
import com.vladislav07.runapp.ui.models.StatisticsUI
import com.vladislav07.runapp.ui.models.UserUI


fun FeedbackUI.toFeedbackDomain() =
    FeedbackDomain(
        topic = topic,
        text = text
    )

fun JogDomain.toJogUI() =
    JogUI(
        id = id,
        userId = userId,
        distance = distance,
        time = time,
        date = date,
        speed = (speed*1000).toInt() / 1000.0
    )

fun UserDomain.toUserUI() =
    UserUI(
        id = id,
        email = email,
        phone = phone,
        role = role,
        firstName = firstName,
        lastName = lastName
    )

fun JogUI.toJogDomain() =
    JogDomain(
        id = id,
        userId = userId,
        distance = distance,
        time = time,
        date = date,
        speed = speed
    )


fun StatisticsDomain.toStatisticsUI() =
    StatisticsUI(
        weekNumber = weekNumber,
        firstDate = firstDate,
        lastDate = lastDate,
        avTime = avTime,
        avDistance = avDistance,
        avSpeed = avSpeed
    )