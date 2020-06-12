package com.standalone.dataformkotlin.data

data class FormFields(
    var name: String?,
    var rate: Long? = 0,
    var qty: Long? = 0,
    var amount: Long =rate?.let { qty?.let { rate*qty } }?:0
)
