package com.vladislav07.runapp.network.retrofit

import com.vladislav07.runapp.network.models.request.FeedbackRequest
import com.vladislav07.runapp.network.models.request.JogNewRequest
import com.vladislav07.runapp.network.models.request.JogUpdateRequest
import com.vladislav07.runapp.network.models.request.UUIDRequest
import com.vladislav07.runapp.network.models.response.JogsAndUserResponse
import com.vladislav07.runapp.network.models.response.UUIDResponse
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

interface JogsApi {

    @POST(Constants.UUID_URL)
    fun loginUUID(@Body uuid: UUIDRequest): Single<UUIDResponse>

    @GET(Constants.GET_JOGS_URL)
    fun getJogs(): Single<JogsAndUserResponse>

    @POST(Constants.NEW_OR_UPDATE_JOG_URL)
    fun createNewJog(@Body jogRequest: JogNewRequest): Completable

    @PUT(Constants.NEW_OR_UPDATE_JOG_URL)
    fun updateJog(@Body jogRequest: JogUpdateRequest): Completable

    @POST(Constants.SEND_FEEDBACK_URL)
    fun sendFeedback(@Body feedbackRequest: FeedbackRequest): Completable
}