package com.ujala.dukaan.ui.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import com.lastblade.androidarchitecturewithhilt.util.Result

abstract class BaseViewModel : ViewModel() {

    protected val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    protected val _toast = MutableLiveData<String>()
    val toast: LiveData<String> get() = _toast

    protected val _snackBarMsg = MutableLiveData<String>()
    val snackBarMsg: LiveData<String> get() = _snackBarMsg

    private val _result = MutableLiveData<Result<Any>>()
    val result: LiveData<Result<Any>>
        get() = _result


    fun executeSuspendedFunction(codeBlock: suspend () -> Flow<Result<Any>>) {
        viewModelScope.launch {
            codeBlock().collect { result ->
                _result.value = result

                when (result) {
                    is Result.ApiError -> {
                        Log.d("RetrofitResult", result.errorBody.toString())
                    }
                    is Result.NetworkError -> {
                        Log.d("RetrofitResult", result.error.toString())
                        result.error.printStackTrace()
                    }
                    is Result.UnknownError -> {
                        result.exception?.printStackTrace()
                        Log.d("RetrofitResult", result.exception.toString())
                    }
                }
            }
        }
    }

}


