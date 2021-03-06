package com.standalone.dataformkotlin.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.standalone.dataformkotlin.R
import com.standalone.dataformkotlin.adapters.ItemListAdapter
import com.standalone.dataformkotlin.data.Item
import com.standalone.dataformkotlin.databinding.ItemListFragmentBinding
import com.standalone.dataformkotlin.utilities.InjectorUtils
import com.standalone.dataformkotlin.viewmodels.ItemListViewModel
import kotlinx.android.synthetic.main.item_list_fragment.view.*

class ItemListFragment : Fragment(), ItemListAdapter.ItemOperation {

    private val viewModel: ItemListViewModel by viewModels {
        InjectorUtils.provideItemListViewModelFactory(this)
    }
    private lateinit var listener: ItemListAdapter.ItemOperation
    private lateinit var binding: ItemListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        listener = this

        binding = ItemListFragmentBinding.inflate(inflater, container, false)
        context ?: return binding.root
        binding.itemList.smoothSnapToPosition(0) //Postion new item to front and scroll to front

        val adapter = ItemListAdapter(listener)
        binding.itemList.adapter = adapter
        subscribeUi(adapter, binding)

        val view = binding.root

        view.fab_create_item.setOnClickListener { navigateToAddItemPage(view) }

        return binding.root
    }


    private fun navigateToAddItemPage(view: View) {
        view.findNavController()
            .navigate(R.id.action_itemListFragment_to_createItemFragment)
    }

    private fun subscribeUi(adapter: ItemListAdapter, binding: ItemListFragmentBinding) {
        viewModel.dataItems.observe(viewLifecycleOwner) { result ->
            binding.hasData = !result.isNullOrEmpty()
            adapter.submitList(result)
        }
    }

    override fun onRemoveItem(view: View, item: Item) {
        viewModel.removeItems(listOf(item))
        Snackbar.make(view, R.string.item_removed_msg, Snackbar.LENGTH_LONG)
            .show()
    }

    fun RecyclerView.smoothSnapToPosition(position: Int, snapMode: Int = LinearSmoothScroller.SNAP_TO_START) {
        val smoothScroller = object : LinearSmoothScroller(this.context) {
            override fun getVerticalSnapPreference(): Int = snapMode
            override fun getHorizontalSnapPreference(): Int = snapMode
        }
        smoothScroller.targetPosition = position
        layoutManager?.startSmoothScroll(smoothScroller)
    }
}