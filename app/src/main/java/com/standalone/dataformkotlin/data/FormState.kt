package com.standalone.dataformkotlin.data

class FormState {
    var nameError: Int?
        private set
    var isDataValid: Boolean = false
        private set
    var amountError: Int?
        private set

    constructor(nameError: Int?, amountError: Int?) {
        this.nameError = nameError
        this.amountError = amountError
        isDataValid = false
    }

    internal constructor(isDataValid: Boolean) {
        nameError = null
        amountError = null
        this.isDataValid = isDataValid
    }

}