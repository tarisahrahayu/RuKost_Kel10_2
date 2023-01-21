package com.example.rukost_kel10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_kalender.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    private fun btnListener(){
        btn_tglsewa.setOnClickListener{
            startActivity(Intent(this, Kalender::class.java))
        }
    }

    fun profile(view: View?){
        val i = Intent(applicationContext, TampilProfileActivity::class.java)
        startActivity(i)
    }

    fun mawar(view: View?){
        val i = Intent(applicationContext, DetailKostMawarActivity::class.java)
        startActivity(i)
    }

    fun vishe(view: View?){
        val i = Intent(applicationContext, DetailKostVisheActivity::class.java)
        startActivity(i)
    }

    fun about(view: View?){
        val i = Intent(applicationContext, AboutActivity::class.java)
        startActivity(i)
    }

    fun raharja(view: View?){
        val i = Intent(applicationContext, DetailKostRaharjaActivity::class.java)
        startActivity(i)
    }

    fun aisyah(view: View?){
        val i = Intent(applicationContext, DetailKostAisyahActivity::class.java)
        startActivity(i)
    }


}