package com.example.rukost_kel10.Model

import com.google.gson.annotations.SerializedName

data class LoginBody(
    @SerializedName("nama_pengguna")
    var nama_pengguna: String,
    @SerializedName("kata_sandi")
    var kata_sandi: String
)
