package com.lastblade.androidarchitecturewithhilt.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lastblade.androidarchitecturewithhilt.base.BaseViewModel
import com.lastblade.androidarchitecturewithhilt.data.DataManager
import com.lastblade.androidarchitecturewithhilt.data.model.User
import kotlinx.coroutines.launch

class UserVM @ViewModelInject constructor(private val dataManager: DataManager) : BaseViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    fun getUsers() {
        viewModelScope.launch {
            _isLoading.value = true
            val response = dataManager.apiHelper.getUsers()

            handleResponse(response) { success ->
                val data = success.data as List<User>

                _users.value = data
            }
        }
    }




}