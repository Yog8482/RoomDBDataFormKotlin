package com.standalone.dataformkotlin.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.standalone.dataformkotlin.R
import com.standalone.dataformkotlin.utilities.InjectorUtils
import com.standalone.dataformkotlin.viewmodels.CreateItemViewModel
import com.standalone.dataformkotlin.viewmodels.ItemListViewModel

class ItemListFragment : Fragment() {

    private val viewModel: ItemListViewModel by viewModels {
        InjectorUtils.provideItemListViewModelFactory(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view =inflater.inflate(R.layout.item_list_fragment, container, false)
        view.findViewById<FloatingActionButton>(R.id.fab_create_item).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_itemListFragment_to_createItemFragment)
        }

        return view
    }

}