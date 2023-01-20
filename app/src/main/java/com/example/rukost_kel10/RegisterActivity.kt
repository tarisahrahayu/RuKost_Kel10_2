package com.example.rukost_kel10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.rukost_kel10.Model.ApiInterface
import com.example.rukost_kel10.Model.RegisterBody
import com.example.rukost_kel10.Model.RetrofitInstance
import okhttp3.Response
import okhttp3.ResponseBody

class RegisterActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var editText3: EditText
    lateinit var editText4: EditText
    lateinit var editText5: EditText
    lateinit var editText6: EditText
    lateinit var editText7: EditText
    lateinit var string1: String
    lateinit var string2: String
    lateinit var string3: String
    lateinit var string4: String
    lateinit var string5: String
    lateinit var string6: String
    lateinit var string7: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        title = "KotlinApp"
        button = findViewById(R.id.btn_daftar)
        editText1 = findViewById(R.id.et_namap)
        editText2 = findViewById(R.id.et_pass)
        editText3 = findViewById(R.id.et_ttl)
        editText4 = findViewById(R.id.et_kota)
        editText5 = findViewById(R.id.et_nohp)
        editText6 = findViewById(R.id.et_jk)
        editText7 = findViewById(R.id.et_status)

        button.setOnClickListener(){
            string1 = editText1.text.toString()
            string2 = editText2.text.toString()
            string3 = editText3.text.toString()
            string4 = editText4.text.toString()
            string5 = editText5.text.toString()
            string6 = editText6.text.toString()
            string7 = editText7.text.toString()
            singup(string1, string2, string3, string4, string5, string6, string7)
            Log.i("data : ", string1 + string2 + string3 + string4 + string5 + string6 + string7)
        }
    }

    fun keLogin(view: View?){
        val i = Intent(applicationContext, LoginActivity::class.java)
        i.putExtra("Value1", "Sedang berada di halaman Daftar")
        startActivity(i)
    }

    private fun singup(nama_pengguna: String, kata_sandi: String, ttl: String, kota_asal: String,no_hp: String, jk: String, status: String){
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val registerInfo = RegisterBody(nama_pengguna, kata_sandi, ttl, kota_asal, no_hp, jk, status)

        retIn.registerUser(registerInfo).enqueue(object :
            retrofit2.Callback<ResponseBody> {
            override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    this@RegisterActivity,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(
                call: retrofit2.Call<ResponseBody>,
                response: retrofit2.Response<ResponseBody>
            ) {
                if(response.code() == 201){
                    Toast.makeText(this@RegisterActivity,  "Registrasi "+editText1.text.toString()+" Berhasil!", Toast.LENGTH_SHORT).show()
                    val i = Intent(applicationContext, LoginActivity::class.java)
                    i.putExtra("Value1", "Terimakasih, kamu berhasil terdaftar")
                    startActivity(i)
                }
            }
        })
    }
}