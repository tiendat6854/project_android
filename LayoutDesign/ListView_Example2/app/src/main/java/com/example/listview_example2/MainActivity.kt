package com.example.listview_example2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var ds: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addEvent()
    }

    private fun addEvent() {
        btnSave.setOnClickListener {
            hamXuLyNutSave()
        }
    }

    private fun hamXuLyNutSave() {
        var s1: String = edtSdt.text.toString()
        var s2: String = edtName.text.toString()
        if(s1 == "") {
            Toast.makeText(this, "Bạn chưa nhập SĐT", Toast.LENGTH_SHORT).show()
            edtSdt.requestFocus() // đẩy con trỏ văn bản vào ô nhập liệu
        }
        else {
            if(s2 != "") {
                ds.add(s1 + "  ( " + s2 + " )")
                hienThiDS()
            }
            else {
                ds.add(s1)
                hienThiDS()
            }
        }
    }

    private fun hienThiDS() {
        lvSdt.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ds)
        edtSdt.setText("")
        edtName.setText("")
        edtSdt.requestFocus() // đẩy con trỏ văn bản vào ô nhập liệu
    }
}