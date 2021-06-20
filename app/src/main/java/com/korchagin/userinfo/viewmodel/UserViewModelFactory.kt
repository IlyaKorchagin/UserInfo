package com.korchagin.userinfo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.korchagin.userinfo.repository.UsersRepository

@Suppress("UNCHECKED_CAST")
class UserViewModelFactory(
    private val repository: UsersRepository
):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(repository) as T
    }
}