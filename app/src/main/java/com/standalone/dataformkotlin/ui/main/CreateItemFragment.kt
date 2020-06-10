package com.standalone.dataformkotlin.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.standalone.dataformkotlin.R
import com.standalone.dataformkotlin.viewmodels.CreateItemViewModel

class CreateItemFragment : Fragment() {

    companion object {
        fun newInstance() = CreateItemFragment()
    }

    private lateinit var viewModel: CreateItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.create_item_fragment, container, false)
        view.findViewById<Button>(R.id.btn_create_item).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_createItemFragment_to_itemListFragment)
        }
        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreateItemViewModel::class.java)
        // TODO: Use the ViewModel
    }

}