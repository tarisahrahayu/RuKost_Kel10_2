package com.example.rukost_kel10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.app.*
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.metode_bayar.*

class MetodeBayarActivity : AppCompatActivity() {

    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"
    val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metode_bayar)
        buatNotifikasi()

        val intent = Intent (this, MainActivity2::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run{
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notification = NotificationCompat.Builder (this, CHANNEL_ID)
            .setContentTitle("Kamar Berhasil Disewa!")
            .setContentText("Mohon dicek kembali data diri!")
            .setSmallIcon(R.drawable.ic_notif)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        val  notificationManager = NotificationManagerCompat.from(this)
        btn_tglsewa.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID, notification)
        }

    }

    fun buatNotifikasi() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
                .apply {
                    lightColor = Color.GREEN
                    enableLights(true)
                }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

    fun berhasil(view: View?){
        val i = Intent(applicationContext, InfoBerhasilActivity::class.java)
        startActivity(i)
    }

    fun backHome(view: View?){
        val i = Intent(applicationContext, HomeActivity::class.java)
        startActivity(i)
    }
}

