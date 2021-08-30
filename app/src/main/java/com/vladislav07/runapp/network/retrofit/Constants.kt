package com.vladislav07.runapp.network.retrofit

object Constants {
    const val BASE_URL = "https://jogtracker.herokuapp.com/api/v1/"
    const val UUID_URL = "auth/uuidLogin"
    const val GET_JOGS_URL = "data/sync"
    const val NEW_OR_UPDATE_JOG_URL = "data/jog"
    const val SEND_FEEDBACK_URL = "feedback/send"
    const val CONNECT_TIMEOUT: Long = 60 // 60 seconds
    const val READ_WRITE_TIMEOUT: Long = 120 // 120 seconds
}