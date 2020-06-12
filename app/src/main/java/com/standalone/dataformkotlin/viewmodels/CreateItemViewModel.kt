package com.standalone.dataformkotlin.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.standalone.dataformkotlin.R
import com.standalone.dataformkotlin.data.FormFields
import com.standalone.dataformkotlin.data.FormState
import com.standalone.dataformkotlin.data.Item
import com.standalone.dataformkotlin.data.ItemRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CreateItemViewModel internal constructor(
    private val itemRepository: ItemRepository
) : ViewModel() {

    private val _newFormState = MutableLiveData<FormState>()
    private val _itemAmount = MutableLiveData<String>()

    private val _result = MutableLiveData<Long>()
    private val _itemToAdd = MutableLiveData<FormFields>()

    val newFormState: LiveData<FormState>
        get() = _newFormState

    val result: LiveData<Long>
        get() = _result

    val itemAmount: LiveData<String>
        get() = _itemAmount

    init {
        _itemAmount.value="0"
    }

    val itemToAdd: LiveData<FormFields>
        get() = _itemToAdd


    fun addData(fields: FormFields) {
        val items= fields.name?.let { Item(name = it,rate = fields.rate.toString(),
            qty = fields.qty.toString(),amount = fields.amount.toString()) }

        viewModelScope.launch {
            itemRepository.insertItems(listOf(items) as List<Item>)
            _result.value = 1
        }
    }


    fun formDataChanged(name: String?, qty: Long?, rate: Long?) {

        _itemToAdd.value= FormFields(name,rate,qty)

        if (!isNameValid(name)) {
            _newFormState.value = FormState(R.string.invalid_name)
        } else {
            _newFormState.value = FormState(true)//Valid form, Enable add button
        }
        calculateAmount(qty?:0, rate?:0)

    }

    private fun calculateAmount(qty: Long = 0, rate: Long = 0) {
        _itemAmount.value = "${ rate*qty}"

    }

    // name validation check
    private fun isNameValid(name: String?): Boolean {
        if (name == null) {
            return false
        }
        return !(name.trim().isEmpty())

    }

}