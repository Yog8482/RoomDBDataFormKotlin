package com.standalone.dataformkotlin.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


/**
 * The Data Access Object for the Item class.
 */

@Dao
interface ItemDao {

    @Query("SELECT * from items")
    fun getItems(): LiveData<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<Item>)
}
