package com.example.gridview

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomGridview (val activity: Activity,val list: List<OutData>) :ArrayAdapter<OutData>(activity,
    R.layout.layout_item){
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contexs = activity.layoutInflater
        //layoutInflater giúp chuyển đổi xml layout thành view trong android
        val rowView = contexs.inflate(R.layout.layout_item,parent,false)
        val images = rowView.findViewById<ImageView>(R.id.imgPhim)
        val txtTenPhim = rowView.findViewById<TextView>(R.id.txtTenPhim)

        images.setImageResource(list[position].images)
        txtTenPhim.text = list[position].tenphim
        return rowView
    }
}
