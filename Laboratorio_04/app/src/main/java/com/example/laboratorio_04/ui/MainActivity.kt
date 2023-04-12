package com.example.laboratorio_04.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.laboratorio_04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textButton.setOnClickListener() {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("NAME", binding.namefield.text.toString())
            intent.putExtra("EMAIL", binding.emailfield.text.toString())
            intent.putExtra("PHONE", binding.phonefield.text.toString())
            startActivity(intent)
        }

    }

    companion object {
        const val NAME = "NAME"
        const val EMAIL = "EMAIL"
        const val PHONE = "PHONE"
    }
}