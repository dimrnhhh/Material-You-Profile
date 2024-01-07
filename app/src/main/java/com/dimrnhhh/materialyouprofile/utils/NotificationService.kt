package com.dimrnhhh.materialyouprofile.utils

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.dimrnhhh.materialyouprofile.screens.EditFragment
import com.dimrnhhh.materialyouprofile.R

class NotificationService(private val context: Context ) {

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    fun showNotification() {
        val activityIntent = Intent(context, EditFragment::class.java)
        val activityPandingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) PendingIntent.FLAG_IMMUTABLE else 0
        )

        val incrementIntent = PendingIntent.getBroadcast(
            context,
            2,
            Intent(context, NotificationReceiver::class.java),
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_account)
            .setContentTitle("Penyimpanan Berhasil")
            .setContentText("Data yang dimasukan berhasil disimpan")
            .setContentIntent(activityPandingIntent)
            .build()

        notificationManager.notify(1, notification)
    }
    companion object{
        const val COUNTER_CHANNEL_ID = "counter_channel_id"
    }
}