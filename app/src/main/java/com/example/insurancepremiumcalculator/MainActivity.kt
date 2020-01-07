package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {

            val age: Int = spinnerAge.selectedItemPosition
            val gender = radioGroupGender.checkedRadioButtonId
            var maleExtra = 0
            var smokerExtra = 0
            var premium = 0
            when (age) {
                0 -> premium = 60
                1 -> premium = 70
                2 -> premium = 90
                3 -> premium = 120
                4 -> premium = 150
            }

            if (gender == R.string.male) {
                when (age) {
                    0 -> maleExtra = 0//less than 17
                    1 -> maleExtra = 50//from 17 to 25
                    2 -> maleExtra = 100//from 26 to 30
                    3 -> maleExtra = 150//from 31 to 40
                    else -> maleExtra = 200//more than 41
                }
            }

            val smoker: Boolean = checkBoxSmoker.isChecked
            if (smoker) {
                when (age) {
                    0 -> smokerExtra = 0//less than 17
                    1 -> smokerExtra = 100//from 17 to 25
                    2 -> smokerExtra = 150//from 26 to 30
                    3 -> smokerExtra = 200//from 31 to 40
                    4 -> smokerExtra = 250//from 41 to 55
                    else -> smokerExtra = 300//more than 55
                }
                textViewPremium.text = String.format("%s %d", "RM ", premium)
            }

            if (gender == R.string.male) {
                textViewPremium.text = String.format(
                    "Premium = %s %d \nExtra payment for male = %s %d \n Extra Smoker payment = %s %d\nTotal Payment = %s %d",
                    "RM ", premium,
                    "RM ", maleExtra,
                    "RM ", smokerExtra,
                    "RM ", (premium + maleExtra + smokerExtra)
                )
            } else {
                textViewPremium.text = String.format(
                    "Premium = %s %d \nExtra Smoker Payment = %s %d\n" + "Total Payment = %s %d",
                    "RM ", premium,
                    "RM ", smokerExtra,
                    "RM ", (premium + smokerExtra)
                )
            }
        }
        buttonReset.setOnClickListener {
            spinnerAge.setSelection(0)
            checkBoxSmoker.isChecked = false
            radioButtonMale.isChecked = false
            radioButtonFemale.isChecked = false
            textViewPremium.setText("")
        }

    }

}