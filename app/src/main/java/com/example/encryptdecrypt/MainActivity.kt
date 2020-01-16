package com.example.encryptdecrypt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEncrypt.setOnClickListener {
            intent = Intent(this, SecondScreen::class.java)
            intent.putExtra("type", "Encrypt")
            intent.putExtra("title", "Encrypt")
            startActivity(intent)
        }
        btnDecrypt.setOnClickListener {
            intent = Intent(this, SecondScreen::class.java)
            intent.putExtra("type","Decrypt" )
            intent.putExtra("title", "Decrypt")
            startActivity(intent)
        }
    }
}
