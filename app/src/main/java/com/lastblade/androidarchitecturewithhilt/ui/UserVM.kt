package com.lastblade.androidarchitecturewithhilt.ui

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lastblade.androidarchitecturewithhilt.R
import com.lastblade.androidarchitecturewithhilt.data.DataManager
import com.lastblade.androidarchitecturewithhilt.data.model.User
import com.ujala.dukaan.ui.base.BaseViewModel
import dagger.hilt.android.qualifiers.ApplicationContext

class UserVM @ViewModelInject constructor(
    private val dataManager: DataManager,
    @ApplicationContext val context: Context
) : BaseViewModel() {


    fun createUser(mobileNo: String) {
        if (mobileNo.isMobileValid()) {
            executeSuspendedFunction { dataManager.apiHelper.createUser(mobileNo) }
        } else
            _snackBarMsg.value = context.getString(R.string.mobile_no_valid_msg)
    }


}

fun String.isMobileValid(): Boolean {
    if (!this.isNullOrEmpty() && this.length == 11) {
        val prefix = this.substring(0, 3)
        return prefix == "017" || prefix == "016" || prefix == "018" || prefix == "015" || prefix == "019" || prefix == "013" || prefix == "014"
    }
    return false
}