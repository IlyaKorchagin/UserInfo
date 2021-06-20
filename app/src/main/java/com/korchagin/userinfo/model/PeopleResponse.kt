package com.korchagin.userinfo.model

import com.google.gson.annotations.SerializedName

data class PeopleResponse (
    @SerializedName("response")
    val people: List<People>
)