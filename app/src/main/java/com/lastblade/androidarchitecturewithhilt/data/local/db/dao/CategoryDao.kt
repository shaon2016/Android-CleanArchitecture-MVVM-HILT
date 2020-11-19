package com.example.structure.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.lastblade.androidarchitecturewithhilt.data.local.db.entity.Category


@Dao
interface CategoryDao {

    @Query("SELECT * FROM Category")
    abstract fun getAll(): List<Category>

    @Insert
    abstract fun insert(categories: List<Category>): List<Long>

    @Insert
    abstract fun insert(users: Category)

    @Query("DELETE FROM Category")
    abstract fun delete(): Int

    @Delete
    abstract fun delete(categories: List<Category>): Int

    @Delete
    abstract fun delete(category: Category): Int
}