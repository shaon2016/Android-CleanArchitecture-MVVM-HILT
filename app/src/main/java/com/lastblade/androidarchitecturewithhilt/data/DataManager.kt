package com.lastblade.androidarchitecturewithhilt.data

import com.lastblade.androidarchitecturewithhilt.data.local.db.RoomHelper
import com.lastblade.androidarchitecturewithhilt.data.local.preference.PreferencesHelper
import com.lastblade.androidarchitecturewithhilt.data.remote.ApiHelper
import javax.inject.Inject

class DataManager @Inject constructor(
    preferencesHelper: PreferencesHelper, roomHelper: RoomHelper, apiHelper: ApiHelper
)  {

    val mPref = preferencesHelper
    val roomHelper = roomHelper
    val apiHelper = apiHelper

}