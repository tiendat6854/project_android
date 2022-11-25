package com.example.activites

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.edt_num_a
import kotlinx.android.synthetic.main.activity_main.edt_num_b
import kotlinx.android.synthetic.main.activity_manhinh3.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show()

        btnGo.setOnClickListener {
            val i = Intent(this, manhinh2::class.java)
            i.putExtra("STR1", "Đây là màn hình 2")
            startActivity(i)
        }

        btnGo2.setOnClickListener {
            val i2 = Intent(Intent.ACTION_VIEW, Uri.parse("http://youtube.com"))
            startActivity(i2)
        }

        btn_new_dialog.setOnClickListener {
            val i3 = Intent(this, Dialog::class.java)
            startActivity(i3)
        }

        btn_sum.setOnClickListener {
            if(edt_num_a.getText().toString() != "" && edt_num_b.getText().toString() != "") {
                val i4 = Intent(this, manhinh3::class.java)

                val bundle = Bundle()
                bundle.putInt("NUM_A", Integer.parseInt(edt_num_a.getText().toString()))
                bundle.putInt("NUM_B", Integer.parseInt(edt_num_b.getText().toString()))
                i4.putExtras(bundle)
                startActivity(i4)
            }
        }

        val sub1 = Fragment1()
        val sub2 = Fragment2()

        btn_f1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl1, sub1)
                commit()
            }
        }
        btn_f2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl1, sub2)
                commit()
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "onRestart()", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show()
    }
}