package com.example.firebase


import android.annotation.SuppressLint
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class myfirebase :FirebaseMessagingService() {
    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
        getnotificationfromfirebase(p0.notification!!.title, p0.notification!!.body)
    }

    private fun getnotificationfromfirebase(title: String?, body: String?) {
        val bulider = NotificationCompat.Builder(this,"notifi").apply {
            this.setSmallIcon(R.drawable.ic_notifi)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
        }.build()
       NotificationManagerCompat.from(this).notify(101,bulider)




    }
}