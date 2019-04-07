package com.yagiz.learn.todo.auth

interface IAuthNavigator {

    fun registerWithEmailAndPass(email: String, password: String)

    fun signInWithEmailAndPass(email: String, password: String)

}
