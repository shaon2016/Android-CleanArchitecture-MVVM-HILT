package com.lastblade.androidarchitecturewithhilt.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lastblade.androidarchitecturewithhilt.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    protected val _toast = MutableLiveData<String>()
    val toast: LiveData<String> get() = _toast


//    protected  fun handleResponse(response: Result<Any>) {
//        _isLoading.value = true
//        when (response) {
//            is Result.Success -> {
//                _isLoading.value = false
////                success(response)
//                onSuccess(response.data)
//            }
//
//            is Result.ApiError -> {
//                _isLoading.value = false
//                // TODO toast
//            }
//
//            is Result.NetworkError -> {
//                _isLoading.value = false
//                _toast.value = response.error.message
//            }
//
//            is Result.UnknownError -> {
//                _isLoading.value = false
//                response.exception?.let {
//                    _toast.value = it.message
//                }
//            }
//        }
//    }

    private val _result = MutableLiveData<Result<Any>>()
    val result: LiveData<Result<Any>>
        get() = _result


    fun executeSuspendedFunction(codeBlock: suspend () -> Flow<Result<Any>>) {
        viewModelScope.launch {
            codeBlock().collect { result ->
                _result.value = result

                when (result) {
                    is Result.ApiError -> {

                    }
                    is Result.NetworkError -> {

                    }
                    is Result.UnknownError -> {

                    }
                }
            }
        }
    }


}


