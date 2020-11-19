package com.lastblade.androidarchitecturewithhilt.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.structure.data.local.dao.CategoryDao
import com.lastblade.androidarchitecturewithhilt.data.local.db.entity.Category


@Database(entities = [Category::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
}