package com.standalone.dataformkotlin.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.standalone.dataformkotlin.MainActivity
import com.standalone.dataformkotlin.R
import com.standalone.dataformkotlin.data.FormFields
import com.standalone.dataformkotlin.databinding.CreateItemFragmentBinding
import com.standalone.dataformkotlin.utilities.InjectorUtils
import com.standalone.dataformkotlin.viewmodels.CreateItemViewModel
import java.lang.NumberFormatException

class CreateItemFragment : Fragment() {

    private val createItemViewModel: CreateItemViewModel by viewModels {
        InjectorUtils.provideCreateItemViewModelFactory(this)
    }

    private lateinit var binding: CreateItemFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (requireActivity() as MainActivity).title = "Fill Details"

        binding = CreateItemFragmentBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.txtItemName.addTextChangedListener(afterTextChangedListener)
        binding.txtQty.addTextChangedListener(afterTextChangedListener)
        binding.txtRate.addTextChangedListener(afterTextChangedListener)

        binding.apply {
            viewModel = createItemViewModel
            lifecycleOwner = viewLifecycleOwner
            callback = object : AddItemCallback {
                override fun add(formFields: FormFields) {
                    binding.btnCreateItem.isEnabled = false
                    createItemViewModel.addData(formFields)

                }

            }
        }

//        toolbar.setNavigationOnClickListener { view ->
//            view.findNavController().navigateUp()
//        }

        createItemViewModel.result.observe(viewLifecycleOwner) { result ->

            binding.btnCreateItem.isEnabled = true

            if (result > 0) {
                Snackbar.make(binding.root, R.string.add_item_success, Snackbar.LENGTH_LONG)
                    .show()

                navigateToList(binding.root)
            } else {
                Snackbar.make(binding.root, R.string.add_item_fail, Snackbar.LENGTH_LONG)
                    .show()

            }
        }
        return binding.root

    }


    var afterTextChangedListener: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(
            s: CharSequence,
            start: Int,
            count: Int,
            after: Int
        ) {
            // ignore
        }

        override fun onTextChanged(
            s: CharSequence,
            start: Int,
            before: Int,
            count: Int
        ) {
            // ignore
        }

        override fun afterTextChanged(s: Editable) {

            var qntity: Long=0
            var rate: Long=0
            try {
                if (binding.txtQty.text.trim().toString().length > 0)
                    qntity = java.lang.Long.parseLong(binding.txtQty.text.trim().toString())
                else
                    qntity = 0

                if (binding.txtRate.text.trim().toString().length > 0)
                    rate = java.lang.Long.parseLong(binding.txtRate.text.trim().toString())
                else
                    rate = 0
            } catch (ex: NumberFormatException) {
                Toast.makeText(context, "Limit exceed.", Toast.LENGTH_LONG).show()
            }

            createItemViewModel.formDataChanged(
                binding.txtItemName.text.toString(),
                qty = qntity,
                rate = rate
            )
        }
    }


    private fun navigateToList(view: View) {
        view.findNavController()
            .navigateUp()
    }


    interface AddItemCallback {
        fun add(formFields: FormFields)
    }
}