package com.lastblade.androidarchitecturewithhilt.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lastblade.androidarchitecturewithhilt.data.model.User
import com.lastblade.androidarchitecturewithhilt.util.Result
import retrofit2.Response

abstract class BaseViewModel : ViewModel() {

    protected val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    protected val _toast = MutableLiveData<String>()
    val toast: LiveData<String> get() = _toast


    protected inline fun handleResponse(response: Result<Any>, success: (Result.Success<Any>) -> Unit) {
        when (response) {
            is Result.Success -> {
                _isLoading.value = false
                success(response)
            }

            is Result.ApiError -> {
                _isLoading.value = false
                // TODO toast
            }

            is Result.NetworkError -> {
                _isLoading.value = false
                _toast.value = response.error.message
            }

            is Result.UnknownError -> {
                _isLoading.value = false
                response.exception?.let {
                    _toast.value = it.message
                }
            }
        }
    }

}


