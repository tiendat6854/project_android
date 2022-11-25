package com.example.fragment

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        val firstFragment = FirstFragment()
        transaction.add(R.id.root, firstFragment)
        transaction.addToBackStack(null)
        transaction.commit()

        val btnAdd = findViewById<Button>(R.id.btn_add)
        val btnReplace = findViewById<Button>(R.id.btn_replace)
        val btnPop = findViewById<Button>(R.id.btn_pop)

        btnAdd.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.root, SecondFragment())
            transaction.addToBackStack(null)   // nhấn nút back trên màn hình để trở về
            transaction.commit()
        }

        btnReplace.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.root, SecondFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        btnPop.setOnClickListener { supportFragmentManager.popBackStack() }
        // nhấn nút pop để trở về, tương tự như nút back của thiết bị

    }
}