package com.example.rukost_kel10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_kalender.*

class FormSewa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_sewa)

        btnListener()

    }

    private fun btnListener(){
        btn_tglsewa.setOnClickListener{
            startActivity(Intent(this, Kalender::class.java))
        }
    }


}