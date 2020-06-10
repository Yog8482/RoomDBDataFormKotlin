package com.standalone.dataformkotlin.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.standalone.dataformkotlin.data.ItemRepository

class ItemListViewModel internal constructor(
    itemRepository: ItemRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    // TODO: Implement the ViewModel
}