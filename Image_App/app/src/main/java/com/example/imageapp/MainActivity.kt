package com.example.imageapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.GridLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var Activitlogic: MainActivity_View_model
    var list = mutableListOf<ImagePath>()
lateinit var adapter : ImageAdapter
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Activitlogic = ViewModelProvider(this).get(MainActivity_View_model::class.java)
        click.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                Log.d(TAG, "onCreate ")
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    101
                )
            } else {
                Toast.makeText(this, "permission granted", Toast.LENGTH_SHORT).show()
                loadingImage()
            }
        }

    }


    @SuppressLint("Recycle")
    @RequiresApi(Build.VERSION_CODES.Q)
    private fun loadingImage() {
        val uri: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.MediaColumns.DATA,
            MediaStore.Images.Media.DISPLAY_NAME
        )
        val order = MediaStore.Images.Media.DATE_TAKEN
        val cursor = contentResolver.query(uri, projection, null, null, "$order DESC")
        val ActivityScope= CoroutineScope(Dispatchers.IO)
        ActivityScope.launch {
            cursor?.let {
                if(it.count>0){
                    while (it.moveToNext()){
                        val path = it.getString(it.getColumnIndex(MediaStore.Images.Media.DATA))
                        list.add(ImagePath(path))
                        withContext(Dispatchers.Main){
                            adapter= ImageAdapter(this@MainActivity,list)
                            val layout= GridLayoutManager(this@MainActivity,4)
                            reyclerdisplay.setHasFixedSize(true)
                            reyclerdisplay.adapter=adapter
                            reyclerdisplay.layoutManager= layout
                            adapter.notifyDataSetChanged()
                        }
                    }
                    Log.d(TAG, "loadingImage : $list")
                }else{
                        withContext(Dispatchers.Main){
                        Toast.makeText(this@MainActivity, "No Image Found !!! ", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 101 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, " permission granted now ", Toast.LENGTH_SHORT).show()
            loadingImage()
        } else {
            Toast.makeText(this, " permission denied ", Toast.LENGTH_SHORT).show()
        }
    }
}