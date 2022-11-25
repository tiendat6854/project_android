package com.example.mvplogin

import android.text.TextUtils
import android.util.Patterns

class User {
    private var email: String
    private var password: String

    constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }

    fun getEmail(): String {
        return email
    }
    fun setEmail(email: String) {
        this.email = email
    }

    fun getPassword(): String {
        return password
    }
    fun setPassword(password: String) {
        this.password = password
    }

    fun isValidEmail(): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPassword(): Boolean {
        return !TextUtils.isEmpty(password) && password.length >= 8
    }
}