package com.chalat.imageuploader.utils

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import com.chalat.imageuploader.FileService
import com.fireoneone.baanruejai.network.GoogleCloudStorageService
import okhttp3.MediaType
import okhttp3.RequestBody
import java.io.File
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import java.io.FileInputStream


/**
 *
 * Created by Chalat Chansima on 3/5/18.
 *
 */
object FileUtils {

//    private val service = Retrofit.Builder()
//            .baseUrl("https://storage.googleapis.com/brj-alp-upload/")
//            .client(client)
//            .build()
//            .create<FileService>(FileService::class.java)
//
//    fun getImageFile(context: Context, ImageUri: Uri?): File {
//        Timber.d("select URI : $ImageUri")
//        val type = context.contentResolver.getType(ImageUri)
//        Timber.d("File Type is : $type")
//        val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
//        val cursor = context.contentResolver.query(
//                ImageUri,
//                filePathColumn,
//                null,
//                null,
//                null
//        )
//        cursor.moveToFirst()
//        val columnIndex = cursor.getColumnIndex(filePathColumn[0])
//        val filePath = cursor.getString(columnIndex)
//        cursor.close()
//        val file = File(filePath)
//        Log.d("fileUtils", "file is $file")
//        return file
//    }
//
//    fun uploadFileBinary(gcsService: GoogleCloudStorageService, file: File, type: String) {
//        if (checkSupportType(type)) {
//            val input = FileInputStream(file)
//            val buf: ByteArray
//            buf = ByteArray(input.available())
//            while (input.read(buf) != -1);
//            Log.d("fileUtils", "file Type is $type")
//            val requestBody = RequestBody
//                    .create(MediaType.parse(type), buf)
//            val call = gcsService.upload(url, requestBody)
//            Log.d("fileUtils", "fileUtil req : $call")
//            call.enqueue(object : Callback<ResponseBody> {
//                override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
//                    Log.d("fileUtils", "uploadFile Fail ${call.toString()} : ${t.toString()}")
//                }
//
//                override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
//                    Log.d("fileUtils", "uploadFile Success ${response.toString()}")
//                }
//            })
//        } else {
//
//        }
//    }
//
//    private fun checkSupportType(fileType: String): Boolean {
//        return when (fileType) {
//            "image/jpeg" -> true
//            "image/png" -> true
//            else -> false
//        }
//    }

}
