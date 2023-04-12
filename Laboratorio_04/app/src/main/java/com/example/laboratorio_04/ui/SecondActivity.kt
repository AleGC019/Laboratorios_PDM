package com.example.laboratorio_04.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.laboratorio_04.R
import com.example.laboratorio_04.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent != null) {
            intent?.extras.apply {
                val name = intent.getStringExtra(MainActivity.NAME)
                val email = intent.getStringExtra(MainActivity.EMAIL)
                val phone = intent.getStringExtra(MainActivity.PHONE)

                binding.textViewName.apply {
                    text = getString(R.string.namefield, name)
                }

                binding.textViewEmail.apply {
                    text = getString(R.string.emailfield, email)
                }

                binding.textViewPhone.apply {
                    text = getString(R.string.telefonofield , phone)
                }

                binding.textButtonShare.setOnClickListener() {
                    val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "This is my text to send. \n $name \n $email \n $phone")
                        type = "text/plain"
                    }

                    val shareIntent = Intent.createChooser(sendIntent, null)
                    startActivity(shareIntent)


                }
            }
        }
    }
}