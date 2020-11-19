package com.lastblade.androidarchitecturewithhilt.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.lastblade.androidarchitecturewithhilt.R
import com.lastblade.androidarchitecturewithhilt.base.BaseActivity
import com.lastblade.androidarchitecturewithhilt.data.model.User
import  com.lastblade.androidarchitecturewithhilt.util.Result

class MainActivity : BaseActivity() {

    private val vm: UserVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun viewRelatedTask() {
        vm.createUser("13131")

        vm.result.observe(this, {
            it?.let {
                when (it) {
                    is Result.InProgress -> {
                        if (it.isLoading)
                            showProgressing()
                        else
                            hideProgressing()
                    }
                    is Result.Success -> {
                        handleSuccessfulResponse(it)
                    }
                }
            }
        })

    }


    private fun handleSuccessfulResponse(success: Result.Success<Any>) {

        if (success.type == User::class.java) {
            // TODO Do your work
        } else {
        }
    }

}