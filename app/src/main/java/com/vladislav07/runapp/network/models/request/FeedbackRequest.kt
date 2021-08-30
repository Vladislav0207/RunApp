package com.vladislav07.runapp.network.models.request

import com.google.gson.annotations.SerializedName

data class FeedbackRequest(
    @SerializedName("topic_id") val topicId : Int,
    @SerializedName("text")val text : String
)
