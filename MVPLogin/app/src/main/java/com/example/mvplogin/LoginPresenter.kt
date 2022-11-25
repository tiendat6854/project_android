package com.example.mvplogin

class LoginPresenter {
    private var loginInterface: LoginInterface

    constructor(loginInterface: LoginInterface) {
        this.loginInterface = loginInterface
    }

    fun login(user: User) {
        if(user.isValidEmail() && user.isValidPassword()) {
            loginInterface.loginSuccess()
        }
        else
        {
            loginInterface.loginError()
        }
    }
}