package com.example.rukost_kel10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class InfoBayarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_bayar)
    }

    fun metodebayar(view: View?){
        val i = Intent(applicationContext, MetodeBayarActivity::class.java)
        startActivity(i)
    }


}