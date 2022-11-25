package com.example.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_manhinh2.*

class manhinh2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manhinh2)

        // nhận dữ liệu từ mainActivity
        val i: Intent = getIntent()

        val str1: String? = i.getStringExtra("STR1")
        txt_str1.setText(str1)

        // quay trở lại main
        btn_back.setOnClickListener {
            val i2 = Intent(this, MainActivity::class.java)
            startActivity(i2)
        }
    }
}