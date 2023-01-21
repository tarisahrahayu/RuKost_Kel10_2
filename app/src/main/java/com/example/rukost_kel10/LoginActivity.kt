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
import com.example.rukost_kel10.Model.LoginBody
import com.example.rukost_kel10.Model.RetrofitInstance
import com.example.rukost_kel10.Session.SessionManager
import kotlinx.android.synthetic.main.activity_kalender.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.detail_kost.*
import okhttp3.ResponseBody

class LoginActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var string1: String
    lateinit var string2: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        title = "KotlinApp"
        button = findViewById(R.id.btn_masuk)
        editText1 = findViewById(R.id.et_namap)
        editText2 = findViewById(R.id.et_pass)

        button.setOnClickListener() {
            string1 = editText1.text.toString()
            string2 = editText2.text.toString()
            daftar(string1, string2)
            Log.i("data : ", string1 + string2)
        }

    }

    private fun daftar(nama_pengguna: String, kata_sandi: String) {
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val daftarInfo = LoginBody(nama_pengguna, kata_sandi)
        retIn.login(daftarInfo).enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
//                    context, untuk fragment
//                    ini untuk activity
                    this@LoginActivity,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(
                call: retrofit2.Call<ResponseBody>,
                response: retrofit2.Response<ResponseBody>
            ) {
                if (response.code() == 200) {
                    Toast.makeText(this@LoginActivity, "Login success!", Toast.LENGTH_SHORT).show()
                    val sessionManager = SessionManager(this@LoginActivity)
                    sessionManager.setLoggin(true)
                    sessionManager.setNama_pengguna(nama_pengguna)
//                    findNavController().navigate(R.id.action_loginAcitvity_to_berandaFragment2)
                    val i = Intent(applicationContext, FormSewa::class.java)
                    i.putExtra("Value1", "Selamat Datang")
                    startActivity(i)
                } else {
                    Toast.makeText(this@LoginActivity, "Login failed!", Toast.LENGTH_SHORT).show()
                }
            }


        })
    }

    fun daftar(view: View?){
        val i = Intent(applicationContext, RegisterActivity::class.java)
        startActivity(i)
    }




}
