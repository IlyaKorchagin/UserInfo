package com.korchagin.userinfo.network

import com.korchagin.userinfo.model.PeopleResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserApi {

    @GET("60bf82449fc30168f1c94107/")
    suspend fun getUsers(): Response<PeopleResponse>

    companion object{
        operator fun invoke(): UserApi{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.jsonbin.io/b/")
                .build()
                .create(UserApi::class.java)
        }
    }
}