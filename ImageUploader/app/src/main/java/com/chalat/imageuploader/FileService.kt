package com.chalat.imageuploader

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


/**
 *
 * Created by Chalat Chansima on 3/5/18.
 *
 */
interface FileService {

    @PUT
    fun upload(
            @Url url: String,
            @Body file: RequestBody
    ): Call<ResponseBody>

    @GET("uploads/image")
    fun getUploadUrl(
           @Query("imageType") imageType: String,
           @Query("imageName") imageName: String,
           @Query("feature")   feature: String
    ): Call<ImageRequestResponse>

}