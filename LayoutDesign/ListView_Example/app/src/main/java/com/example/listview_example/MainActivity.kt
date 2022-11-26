package com.example.listview_example

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mauxanh = Color.parseColor("#99FFFF")
        lvQuocGia.setBackgroundColor(mauxanh)

        addEvent()
    }

    private fun addEvent() {
        hienThiLvQuocGia()
    }

    private fun hienThiLvQuocGia() {
        var arrQuocGia = resources.getStringArray(R.array.arrQuocGia)
        lvQuocGia.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrQuocGia)
        lvQuocGia.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "Bạn chọn " + arrQuocGia[i], Toast.LENGTH_LONG).show()
        }
    }
}