package com.standalone.dataformkotlin.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.standalone.dataformkotlin.R

class ItemListFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = ItemListFragment()
    }

    private lateinit var viewModel: MainViewModel
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.item_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        val host: NavHostFragment = view
                as NavHostFragment? ?: return

        navController = host.navController

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}