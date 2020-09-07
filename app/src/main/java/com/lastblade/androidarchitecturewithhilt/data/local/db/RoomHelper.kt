package com.lastblade.androidarchitecturewithhilt.data.local.db

import android.content.Context
import androidx.room.Room

class RoomHelper(context: Context)  {

    private var context = context
    private val db = Room.databaseBuilder(context, RoomDB::class.java, "BD_NAME").allowMainThreadQueries().build()


    fun getDatabase(): RoomDB {
        return db
    }
}