package com.standalone.dataformkotlin.data

class FormState {
    var nameError: Int?
        private set
    var isDataValid: Boolean=false
        private set

    constructor(nameError: Int?) {
        this.nameError = nameError
        isDataValid = false
    }

    internal constructor(isDataValid: Boolean) {
        nameError = null
        this.isDataValid = isDataValid
    }

}