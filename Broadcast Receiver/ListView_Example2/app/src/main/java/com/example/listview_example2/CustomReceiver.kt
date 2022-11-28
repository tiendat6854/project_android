package com.example.listview_example2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class CustomReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(CustomReceiver::class.java.simpleName, "Custom receiver")
    }
}