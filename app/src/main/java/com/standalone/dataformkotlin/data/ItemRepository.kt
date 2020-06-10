package com.standalone.dataformkotlin.data

/**
 * Repository module for handling data operations.
 */
class ItemRepository private constructor(val itemDao: ItemDao) {

    fun getItems() = itemDao.getItems()
    suspend fun insertItems(items: List<Item>) = itemDao.insertAll(items)
    suspend fun deleteItems(items: List<Item>) = itemDao.deleteItems(items)

    companion object {
        @Volatile
        private var instance: ItemRepository? = null

        fun getInstance(itemDao: ItemDao) = instance ?: synchronized(this) {
            instance ?: ItemRepository(itemDao).also { instance = it }
        }

    }
}