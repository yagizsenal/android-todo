package com.yagiz.learn.todo.auth

interface IAuthNavigator {
    fun onForgotPassword()
    fun onProceedToRegister()
    fun onRegisterSuccess()
}