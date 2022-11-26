package com.example.listview_example3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // khai báo ds các items list
        var list = mutableListOf<OutData>()
        list.add(OutData(R.drawable.giatocrong, "Gia Tộc Rồng 2022", "Đây là miêu tả của phim gia tộc rồng"))
        list.add(OutData(R.drawable.hoanhon, "Hoàn Hồn 2022", "Đây là miêu tả của phim hoàn hồn"))
        list.add(OutData(R.drawable.thanlan, "Thần Lan Vô Song 2022", "Đây là miêu tả của phim thần lan vô song"))
        list.add(OutData(R.drawable.banghoa, "Băng Hỏa Ma Trù 2022", "Đây là miêu tả của phim băng hỏa ma trù"))
        list.add(OutData(R.drawable.giatocrong, "Gia Tộc Rồng 2022", "Đây là miêu tả của phim gia tộc rồng"))
        list.add(OutData(R.drawable.hoanhon, "Hoàn Hồn 2022", "Đây là miêu tả của phim hoàn hồn"))
        list.add(OutData(R.drawable.thanlan, "Thần Lan Vô Song 2022", "Đây là miêu tả của phim thần lan vô song"))
        list.add(OutData(R.drawable.banghoa, "Băng Hỏa Ma Trù 2022", "Đây là miêu tả của phim băng hỏa ma trù"))
        list.add(OutData(R.drawable.giatocrong, "Gia Tộc Rồng 2022", "Đây là miêu tả của phim gia tộc rồng"))
        list.add(OutData(R.drawable.hoanhon, "Hoàn Hồn 2022", "Đây là miêu tả của phim hoàn hồn"))
        list.add(OutData(R.drawable.thanlan, "Thần Lan Vô Song 2022", "Đây là miêu tả của phim thần lan vô song"))
        list.add(OutData(R.drawable.banghoa, "Băng Hỏa Ma Trù 2022", "Đây là miêu tả của phim băng hỏa ma trù"))

        customAdapter = CustomAdapter(this, list)

        val lvPhim = findViewById<ListView>(R.id.lvPhim)
        lvPhim.adapter = customAdapter

        // listView item click
        lvPhim.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "Bạn chọn " + list[i].title, Toast.LENGTH_LONG).show()
        }
    }
}