package com.example.rukost_kel10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TampilProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tampil_profile)
    }

    fun backHome(view: View?){
        val i = Intent(applicationContext, HomeActivity::class.java)
        startActivity(i)
    }
}