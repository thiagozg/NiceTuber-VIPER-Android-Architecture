package br.com.nicetuber.model

import com.google.gson.annotations.SerializedName

/**
 * Created by thiagozg on 23/10/2017.
 */

data class ChannelStatistics(
        @SerializedName("viewCount")
        var viewCount: String,

        @SerializedName("commentCount")
        var commentCount: String,

        @SerializedName("subscriberCount")
        var subscriberCount: String,

        @SerializedName("hiddenSubscriberCount")
        var isHiddenSubscriberCount: Boolean,

        @SerializedName("videoCount")
        var videoCount: String
)

