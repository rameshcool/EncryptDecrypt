package com.example.encryptdecrypt

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class EncryptDecryptViewModel: ViewModel() {

    val inputText = MutableLiveData<String>()
    val outputValue = MutableLiveData<String>()

    val submitButtonInVisible = Transformations.map(inputText) {
        !it.isNullOrEmpty()
    }


}