package com.example.laboratorio_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private lateinit var fiveCents: ImageView
    private lateinit var tenCents: ImageView
    private lateinit var twentyCents: ImageView
    private lateinit var Onedollar: ImageView
    private lateinit var MoneyText: TextView
    private var cash = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        bind()
        MoneyText.text = "$$cash"
        listeners()
        
    }

    private fun listeners(){

        fiveCents.setOnClickListener {
            cash = (cash + 0.05)
            cash = String.format("%.2f", cash).toDouble()
            MoneyText.text = "$$cash"
        }
        tenCents.setOnClickListener{
            cash = (cash + 0.10)
            cash = String.format("%.2f", cash).toDouble()
            MoneyText.text = "$$cash"
        }
        twentyCents.setOnClickListener{
            cash = (cash + 0.25)
            cash = String.format("%.2f", cash).toDouble()
            MoneyText.text = "$$cash"
        }
        Onedollar.setOnClickListener{
            cash = (cash + 1.00)
            cash = String.format("%.2f", cash).toDouble()
            MoneyText.text = "$$cash"
        }

    }

    private fun bind(){
        fiveCents = findViewById(R.id.imageView)
        tenCents = findViewById(R.id.imageView2)
        twentyCents = findViewById(R.id.imageView3)
        Onedollar = findViewById(R.id.imageView4)
        MoneyText = findViewById(R.id.textView)
    }

}