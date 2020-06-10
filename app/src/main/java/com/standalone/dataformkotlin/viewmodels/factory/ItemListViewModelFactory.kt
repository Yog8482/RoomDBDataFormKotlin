package com.standalone.dataformkotlin.viewmodels.factory

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.standalone.dataformkotlin.data.ItemRepository
import com.standalone.dataformkotlin.viewmodels.ItemListViewModel

class ItemListViewModelFactory(
    private val repository: ItemRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return ItemListViewModel(
            repository,
            handle
        ) as T
    }
}