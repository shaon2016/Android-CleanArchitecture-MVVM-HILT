package com.lastblade.androidarchitecturewithhilt.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Category {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cat_localId")
    public var localId:Int = 0
    @ColumnInfo(name = "id") lateinit var id: String
    @ColumnInfo(name = "name") lateinit var name: String

}