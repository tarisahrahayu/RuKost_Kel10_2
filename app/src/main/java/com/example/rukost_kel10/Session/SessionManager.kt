package com.example.rukost_kel10.Session

import android.content.Context
import android.content.SharedPreferences

class SessionManager(var context: Context?) {
    var PRIVATE_MODE = 0

    private val PREF_NAME = "SharedPreferences"

    private val IS_LOGIN = "is_login"

    var pref: SharedPreferences? = context?.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
    var editor: SharedPreferences.Editor? = pref?.edit()

    fun setLoggin(isLogin: Boolean){
        editor?.putBoolean(IS_LOGIN, isLogin)
        editor?.commit()
    }

    fun isLogin(): Boolean? {
        return pref?.getBoolean(IS_LOGIN, false)
    }

    fun setNama_pengguna(nama_pengguna: String?){
        editor?.putString("Nama Pengguna", nama_pengguna)
    }

    fun getNama_pengguna(): String?{
        return pref?.getString("nama_pengguna", "")
    }

    fun removeData(){
        editor?.clear()
        editor?.commit()
    }
}