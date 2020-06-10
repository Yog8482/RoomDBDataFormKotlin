package com.standalone.dataformkotlin.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.standalone.dataformkotlin.R
import com.standalone.dataformkotlin.utilities.InjectorUtils
import com.standalone.dataformkotlin.viewmodels.CreateItemViewModel

class CreateItemFragment : Fragment() {

    private val viewModel: CreateItemViewModel by viewModels {
        InjectorUtils.provideCreateItemViewModelFactory(this)
    }

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


}