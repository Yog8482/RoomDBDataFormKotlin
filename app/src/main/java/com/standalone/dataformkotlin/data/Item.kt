package com.standalone.dataformkotlin.data

import androidx.room.Entity

@Entity(tableName = "items",primaryKeys = ["name"])
data class Item(
    val name: String,
    val rate: String,
    val qty: String,
    val amount: String
) {
    override fun toString() = name
}