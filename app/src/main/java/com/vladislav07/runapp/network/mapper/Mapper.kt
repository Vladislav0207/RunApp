package com.vladislav07.runapp.network.mapper

import com.vladislav07.runapp.domain.models.FeedbackDomain
import com.vladislav07.runapp.domain.models.JogDomain
import com.vladislav07.runapp.domain.models.JogsAndUserDomain
import com.vladislav07.runapp.domain.models.UserDomain
import com.vladislav07.runapp.network.models.request.FeedbackRequest
import com.vladislav07.runapp.network.models.request.JogNewRequest
import com.vladislav07.runapp.network.models.request.JogUpdateRequest
import com.vladislav07.runapp.network.models.response.JogResponse
import com.vladislav07.runapp.network.models.response.JogsAndUserResponse
import com.vladislav07.runapp.network.models.response.UserResponse
import java.text.SimpleDateFormat
import java.util.*


fun JogResponse.toJogDomain() =
    JogDomain(
        id = id,
        userId = userId,
        distance = distance,
        time = time,
        date = getDateTime(date),
        speed = distance/(time*60)
    )

fun JogDomain.toJogNewRequest() =
    JogNewRequest(
        distance = distance.toFloat(),
        date = getEpochTime(date),
        time = time
    )

fun JogDomain.toJogUpdateRequest() =
    JogUpdateRequest(
        id = id,
        userId = userId,
        distance = distance.toFloat(),
        date = getEpochTime(date),
        time = time
    )

fun UserResponse.toUserDomain() =
    UserDomain(
        id = id,
        email = email,
        phone = phone,
        role = role,
        firstName = firstName,
        lastName = lastName
    )

fun JogsAndUserResponse.toJogsAndUserDomain() =
    JogsAndUserDomain(
        jogs = response.jogs.map { it.toJogDomain() },
        user = response.user[0].toUserDomain()
    )

fun FeedbackDomain.toFeedbackRequest() =
    FeedbackRequest(
        topicId = topic.toIntOrNull()?:1,
        text = text
    )

private fun getDateTime(epoch: String): String {
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
    val netDate = Date(epoch.toLong() * 1000)
    return sdf.format(netDate)
}

private fun getEpochTime(dateString: String): String {
    //TODO
//    val l = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
//    val unix = l.atStartOfDay(ZoneId.systemDefault()).toInstant().epochSecond
    return dateString
}