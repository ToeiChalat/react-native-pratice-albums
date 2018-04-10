package com.chalat.imageuploader

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter
import com.sangcomz.fishbun.FishBun
import com.sangcomz.fishbun.define.Define
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Parcelable
import android.util.Log
import com.chalat.imageuploader.utils.FileUtils


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { _ ->
            FishBun.with(this@MainActivity).setImageAdapter(GlideAdapter())
                    .setCamera(true)
                    .setMaxCount(5)
                    .setMinCount(1)
                    .setActionBarColor(Color.parseColor("#795548"), Color.parseColor("#5D4037"), false)
                    .setActionBarTitleColor(Color.parseColor("#ffffff"))
                    .startAlbum()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int,
                                  imageData: Intent?) {
        super.onActivityResult(requestCode, resultCode, imageData)
        when (requestCode) {
            Define.ALBUM_REQUEST_CODE -> if (resultCode == Activity.RESULT_OK) {
                val path = imageData?.getParcelableArrayListExtra<Parcelable>(Define.INTENT_PATH)
                path?.forEach {
                    Log.d("test", "select Image : $it")
                    val fileUri = it as Uri?
                    val type = contentResolver.getType(fileUri)
                    val file = FileUtils.getImageFile(this, fileUri)
                    val url = "https://storage.googleapis.com/brj-alp-upload/topic-images%2Ftest01-3cd0a281-f2ba-47ba-8fa3-80546b51400f?GoogleAccessId=brj-alp-storage@foo-scasset.iam.gserviceaccount.com&Expires=1520422339&Signature=J09oqx7pBvME0D6xju50grlyKFwzRr6BKCuiRBUeJDaTP%2FJtz1KbZobV9HvNGYBCdvk%2F7a37FtOCdkEMzCiFG0CPZFUU887nUiK5jgud%2BvhjMxMZslZeq%2FYwTHFYnuezV2D0svvZczkTnIAR%2B155HimBJ6sx5u3vziYq4ZgjWNwRkkqLPD2fBc%2BuheXTBCariYtBZVSg%2B6KgvicesWRYOGip19BsG2zqKLhd1IAznD5Hx37P%2FGaqsUx0iMJ53dX0mkMYT%2BI%2FMFIzpJkV8TOqxueCT9JhKtr9CVgg100we3bF1inyeDpIKYumG63EYlVipcTXoQ64qgjGSA%2FffjgQSA%3D%3D"
                    file.let { FileUtils.uploadFileBinary(url, it, type) }
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
