package com.lastblade.androidarchitecturewithhilt.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.blackice.business.data.local_db.entity.Category
import com.example.structure.data.local.dao.CategoryDao


@Database(entities = [Category::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
}