package com.example.listview_example2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var ds: MutableList<String> = mutableListOf()
    private lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addEvent()

        // Broadcast receiver network
        val networkFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(networkReceiver, networkFilter)

        // Broadcast receiver Airplane mode

        val airplaneFilter = IntentFilter()
        airplaneFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        receiver = object : BroadcastReceiver() {
            override fun onReceive(p0: Context?, p1: Intent?) {
                Toast.makeText(p0, "Airplane Mode", Toast.LENGTH_LONG).show()
            }
        }
        registerReceiver(receiver, airplaneFilter)
    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        unregisterReceiver(networkReceiver)
        super.onDestroy()
    }

    private val networkReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val extras = intent.extras
            val networkInfo = extras!!.getParcelable<NetworkInfo>("networkInfo")
            if (networkInfo != null) {
                val state = networkInfo.state
                if (state == NetworkInfo.State.CONNECTED) {
                    Toast.makeText(this@MainActivity, "Wifi ON", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Wifi OFF", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun addEvent() {
        btnSave.setOnClickListener {
            hamXuLyNutSave()
        }
    }

    private fun customBroadcastReceiver(s1: String, s2: String) {
        val intent = Intent("com.example.listview_example2.testCustomBroadcastReceiver")
        intent.putExtra("send_data", "$s1  $s2")
        sendBroadcast(intent)
    }

    private fun hamXuLyNutSave() {
        var s1: String = edtSdt.text.toString()
        var s2: String = edtName.text.toString()

        // send data to different app (Receiver Broadcast app)
        customBroadcastReceiver(s1, s2)

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