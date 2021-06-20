package com.korchagin.userinfo.repository

import com.korchagin.userinfo.network.SafeApiRequest
import com.korchagin.userinfo.network.UserApi


class UsersRepository(
    private val api: UserApi
): SafeApiRequest(){
    suspend fun getUsers() = apiRequest{api.getUsers()}
    }