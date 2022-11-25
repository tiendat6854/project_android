package com.example.mvplogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            val loginPresenter = LoginPresenter(this)
            val strEmail: String = edt_email.getText().toString().trim()
            val strPassword: String = edt_password.getText().toString().trim()

            val user = User(strEmail, strPassword)
            loginPresenter.login(user)
        }
    }

    override fun loginSuccess() {
        tv_message.setVisibility(View.VISIBLE)
        tv_message.setText("Login success")
    }

    override fun loginError() {
        tv_message.setVisibility(View.VISIBLE)
        tv_message.setText("Email or password invalid")
    }
}