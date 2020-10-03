package com.example.structure.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.blackice.business.data.local_db.entity.Category
import kotlinx.coroutines.flow.Flow


@Dao
interface CategoryDao {

    @Query("SELECT * FROM Category")
    abstract fun getAll(): Flow<List<Category>>

    @Query("SELECT * FROM Category where localId=:localId")
    abstract fun getAllById(localId: Int): Flow<List<Category>>

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