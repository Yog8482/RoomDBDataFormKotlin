package com.standalone.dataformkotlin.adapters

import android.view.View
import android.view.View.OnFocusChangeListener
import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}


@BindingAdapter("error")
fun bindError(editText: EditText, strOrResId: Any?) {
    if (strOrResId is Int) {
        editText.error = editText.context.getString((strOrResId))
    } else {
        editText.error = strOrResId as String?
    }
}

@BindingAdapter("onFocus")
fun bindFocusChange(
    editText: EditText,
    onFocusChangeListener: OnFocusChangeListener?
) {
    if (editText.onFocusChangeListener == null) {
        editText.onFocusChangeListener = onFocusChangeListener
    }
}
