package com.standalone.dataformkotlin.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.standalone.dataformkotlin.R
import com.standalone.dataformkotlin.viewmodels.ItemListViewModel

class ItemListFragment : Fragment() {

    companion object {
        fun newInstance() = ItemListFragment()
    }

    private lateinit var viewModel: ItemListViewModel

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ItemListViewModel::class.java)
        // TODO: Use the ViewModel


    }



}