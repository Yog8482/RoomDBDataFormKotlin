package com.standalone.dataformkotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.standalone.dataformkotlin.data.Item
import com.standalone.dataformkotlin.databinding.ItemLayoutBinding


class ItemListAdapter (val listner: ItemOperation) :
    ListAdapter<Item, RecyclerView.ViewHolder>(ItemDiffCallback()) {

    val removeItemListner = listner

    interface ItemOperation {
        fun onRemoveItem(view: View, item: Item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemListViewHolder(removeItemListner,
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as ItemListViewHolder).bind(item)
    }


    class ItemListViewHolder(
        listner: ItemOperation,
        private val binding: ItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.item?.let { item ->
                    listner.onRemoveItem(it,item)

                }
            }
        }

        fun bind(itm: Item) {
            binding.apply {
                item = itm
                executePendingBindings()
            }
        }
    }
}


private class ItemDiffCallback : DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}