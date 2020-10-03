package com.lastblade.androidarchitecturewithhilt.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lastblade.androidarchitecturewithhilt.base.BaseViewModel
import com.lastblade.androidarchitecturewithhilt.data.DataManager
import com.lastblade.androidarchitecturewithhilt.data.model.User
import com.lastblade.androidarchitecturewithhilt.util.Result
import kotlinx.coroutines.launch

class UserVM @ViewModelInject constructor(private val dataManager: DataManager) : BaseViewModel() {

    fun getUsers() {
        executeSuspendedFunction { dataManager.apiHelper.getUsers() }
    }


}