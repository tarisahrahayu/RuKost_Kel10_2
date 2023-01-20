package com.example.rukost_kel10.Model

import com.google.gson.annotations.SerializedName

data class RegisterBody(
    @SerializedName("nama_pengguna")
    val nama_pengguna: String,
    @SerializedName("kata_sandi")
    var kata_sandi: String,
    @SerializedName("ttl")
    var ttl: String,
    @SerializedName("kota_asal")
    var kota_asal: String,
    @SerializedName("no_hp")
    var no_hp: String,
    @SerializedName("jk")
    var jk: String,
    @SerializedName("status")
    var status: String
)
