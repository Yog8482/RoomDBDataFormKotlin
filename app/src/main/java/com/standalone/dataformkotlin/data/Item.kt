package com.standalone.dataformkotlin.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey @ColumnInfo(name = "name")
    val name: String,
    val rate: String,
    val qty: String,
    val amount: String
) {
    override fun toString() = name
}