package com.example.firebase

import android.R
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : AppCompatActivity() {
    private  val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_item)
            FirebaseMessaging.getInstance().subscribeToTopic("seenu")
                .addOnCompleteListener { task ->
                    var msg ="done"
                    if (!task.isSuccessful) {
                        msg = "failed"
                    }
                    Log.d(TAG, msg)
                    Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
        }

    }
}