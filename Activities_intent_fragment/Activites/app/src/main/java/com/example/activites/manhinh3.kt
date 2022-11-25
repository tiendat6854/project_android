package com.example.activites

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_manhinh2.*
import kotlinx.android.synthetic.main.activity_manhinh3.*

class manhinh3 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manhinh3)

        val i = intent
        val bundle = i.extras

        if(bundle != null) {
            val numA = bundle.getInt("NUM_A", 0)
            txt_num_a.setText("Number 1 =  " + numA.toString())
            val numB = bundle.getInt("NUM_B", 0)
            txt_num_b.setText("Number 2 =  " + numB.toString())

            btn_cal.setOnClickListener {
                txt_sum.setText("SUM = " + (numA + numB).toString())
            }
        }
    }
}