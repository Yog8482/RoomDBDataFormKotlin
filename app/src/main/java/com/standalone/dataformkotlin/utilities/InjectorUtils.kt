package com.standalone.dataformkotlin.utilities

import android.content.Context
import androidx.fragment.app.Fragment
import com.standalone.dataformkotlin.data.AppDatabase
import com.standalone.dataformkotlin.data.ItemRepository
import com.standalone.dataformkotlin.viewmodels.factory.CreateItemViewModelFactory
import com.standalone.dataformkotlin.viewmodels.factory.ItemListViewModelFactory

object InjectorUtils {

    private fun getItemrepository(context: Context): ItemRepository {
        return ItemRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).ItemDao()
        )
    }

    fun provideItemListViewModelFactory(fragment: Fragment): ItemListViewModelFactory {
        return ItemListViewModelFactory(
            getItemrepository(fragment.requireContext()),
            fragment
        )
    }

    fun provideCreateItemViewModelFactory(fragment: Fragment): CreateItemViewModelFactory {
        return CreateItemViewModelFactory(
            getItemrepository(fragment.requireContext()),
            fragment
        )
    }
}