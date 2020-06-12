package com.standalone.dataformkotlin.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.standalone.dataformkotlin.data.Item
import com.standalone.dataformkotlin.data.ItemRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ItemListViewModel internal constructor(
    private val itemRepository: ItemRepository
) : ViewModel() {


    val dataItems:LiveData<List<Item>> = itemRepository.getItems()

    fun removeItems(items: List<Item>) {
        viewModelScope.launch {
            itemRepository.deleteItems(items)
        }
    }

}