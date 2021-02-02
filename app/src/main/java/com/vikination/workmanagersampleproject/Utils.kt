package com.vikination.workmanagersampleproject

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class Utils {
    companion object{

        const val CHANNEL_ID = "simple_notification"
        const val NOTIFICATION_CHANNEL_NAME = "test_chanel"
        const val NOTIFICATION_ID = 10

        fun showNotification(context: Context, message: String){
            val builder = NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Work Manager Notification")
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            with(NotificationManagerCompat.from(context)){

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
                    val importance = NotificationManager.IMPORTANCE_HIGH
                    val notificationChannel = NotificationChannel(
                        CHANNEL_ID,
                        NOTIFICATION_CHANNEL_NAME,importance)
                    createNotificationChannel(notificationChannel)
                }

                notify(NOTIFICATION_ID, builder.build())
            }
        }

    }
}