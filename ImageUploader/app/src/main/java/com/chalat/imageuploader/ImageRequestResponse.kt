package com.chalat.imageuploader

import com.google.gson.annotations.SerializedName

/**
 *
 * Created by Chalat Chansima on 3/7/18.
 *
 */
data class ImageRequestResponse (
        @SerializedName("url")          val url: String,
        @SerializedName("limitSize")    val limitSize: String,
        @SerializedName("imageKey")     val imageKey: String
)