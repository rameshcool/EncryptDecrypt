package com.example.encryptdecrypt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.encryptdecrypt.databinding.SecondscreenBinding
import kotlinx.android.synthetic.main.secondscreen.*

class SecondScreen: AppCompatActivity() {

    private lateinit var viewModel: EncryptDecryptViewModel
    private lateinit var binding: SecondscreenBinding
    private val type: String by lazy {
        intent.extras?.getString("type")?:""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = intent.extras?.getString("title")?:""

        binding = DataBindingUtil.setContentView(this, R.layout.secondscreen) as SecondscreenBinding
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(EncryptDecryptViewModel::class.java)
        binding.viewModel = viewModel

        btnSubmit.setOnClickListener {
            hideKeyboard(this)
            if (type == "Encrypt") {

                viewModel.outputValue.postValue(encrypt(viewModel.inputText.value!!))
            } else if(type == "Decrypt"){

                viewModel.outputValue.postValue(decrypt(viewModel.inputText.value!!))
            }

        }

        inputText.setOnClickListener {
            viewModel.inputText.postValue(null)
            viewModel.outputValue.postValue(null)
        }

    }

    fun encrypt(text: String): String{
        var readyText = text
        readyText += '/'
        var cipherText = ""
        var a:Char = text[0]
        var count = -1
        readyText.forEach{
            count++
            if(a != it)
            {
                cipherText = cipherText + a + count
                a = it
                count = 0
            }
        }
        return cipherText
    }

    fun decrypt(cipherText: String): String{
        var text = ""
        var a:Char = cipherText[0]
        cipherText.forEach {
            if(it.isDigit()){
                for(i in 1 .. it.toString().toInt()){
                    text += a
                }
            }
            else{
                a = it
            }
        }
        return text
    }
}