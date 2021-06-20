package com.korchagin.userinfo.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class People(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("surname")
    val surname: String,
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("company")
    val company: String,
    @SerializedName("avatar_url")
    val avatar_url: String,
    @SerializedName("specialty")
    val specialty: String
) : Serializable