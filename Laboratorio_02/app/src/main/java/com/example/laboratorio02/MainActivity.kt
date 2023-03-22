package com.example.laboratorio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import java.lang.StrictMath.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText


    private lateinit var textWeightResult: TextView
    private lateinit var textResult: TextView
    private lateinit var infoTextView: TextView

    private lateinit var BtnCalculate: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Para despues colocarlo en if
        //BMI = weight / (height * height)
        // Less than 18.5: Underweight
        // Between 18.5 and 24.9: Normal weight
        // Between 25 and 29.9: Overweight
        // 30 or more: Obese

        bind()

        BtnCalculate.setOnClickListener(){
            val weight = weightEditText.text.toString()
            val height = heightEditText.text.toString()


            if(!validateInput(weight, height)){
                clearTextViews()
                return@setOnClickListener
            }

            val bmi: Float = calculate(weight.toFloat(), height.toFloat())
            val bmiTwoDigits = String.format("%.2f", bmi).toFloat()


            clearFocus()
            clearTextViews()
            displayResult(bmiTwoDigits)

        }

    }

    private fun validateInput(weight: String?, height: String?): Boolean {
        when{
            weight.isNullOrEmpty() ->{
                Toast.makeText(this, "Weight is required", Toast.LENGTH_SHORT).show()
                return false
            }
            height.isNullOrEmpty() ->{
                Toast.makeText(this, "Height is required", Toast.LENGTH_SHORT).show()
                return false
            }
        }

        return true
    }


    private fun calculate(weight: Float, height: Float): Float {
        return weight / ((height/100) * (height/100) )
    }

    private fun displayResult(bmi: Float){

        textWeightResult.text = bmi.toString()
        infoTextView.text = "(Normal range is 18.5 - 24.9)"

        var information = ""
        var color = 0


        when{
            bmi < 18.5 -> {
                information = "You are underweight"
                color = R.color.under_weight
            }
            bmi in 18.5..24.9 -> {
                information = "You are in a healthy weight range"
                color = R.color.normal_weight
            }
            bmi in 25.0..29.9 -> {
                information = "You are overweight"
                color = R.color.over_weight
            }
            bmi > 30.00 -> {
                information = "You are obese"
                color = R.color.obese
            }
        }

        textResult.text = information
        textResult.setTextColor(ContextCompat.getColor(this, color))

    }

    private fun bind(){

        weightEditText = findViewById(R.id.weight_input)
        heightEditText = findViewById(R.id.height_input)

        textWeightResult = findViewById(R.id.txt_result_value)
        textResult = findViewById(R.id.txt_result)
        infoTextView = findViewById(R.id.info_text_view)

        BtnCalculate = findViewById(R.id.btn_calculate)

    }

    private fun clearTextViews() {
        weightEditText.text.clear()
        heightEditText.text.clear()
    }

    private fun clearFocus() {
        weightEditText.clearFocus()
        heightEditText.clearFocus()
    }
}