package com.standalone.dataformkotlin.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.standalone.dataformkotlin.R

class CreateItemFragment : Fragment() {

    companion object {
        fun newInstance() = CreateItemFragment()
    }

    private lateinit var viewModel: CreateItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_item_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CreateItemViewModel::class.java)
        // TODO: Use the ViewModel
    }

}