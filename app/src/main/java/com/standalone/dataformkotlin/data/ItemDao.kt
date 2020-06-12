package com.standalone.dataformkotlin.data

import androidx.lifecycle.LiveData
import androidx.room.*


/**
 * The Data Access Object for the Item class.
 */

@Dao
interface ItemDao {

    @Query("SELECT * from items")
    fun getItems(): LiveData<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<Item>)

    @Delete
    suspend fun deleteItems(items: List<Item>)
}
