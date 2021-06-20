package com.korchagin.userinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.korchagin.userinfo.model.PeopleResponse
import com.korchagin.userinfo.repository.UsersRepository
import com.korchagin.userinfo.util.Coroutines
import kotlinx.coroutines.Job

class UserViewModel(
    private val repository: UsersRepository
):ViewModel() {
    private lateinit var job: Job
    private val _users = MutableLiveData<PeopleResponse>()
    val users: LiveData<PeopleResponse>
        get() = _users

    fun getUsers() {
        job = Coroutines.ioThenMain(
            { repository.getUsers() },
            { _users.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}