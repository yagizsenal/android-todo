package com.yagiz.learn.todo.auth

import com.yagiz.learn.todo.api.ApiService
import com.yagiz.learn.todo.model.TaskItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthApiClient @Inject constructor(val apiService: ApiService) {

    var user: User? = null
        private set

    fun register(email: String, username:String,password: String): Boolean {
        user = User("registeredUser", arrayListOf())
        return true;
    }

    fun signInWithGoogle(): Boolean {
        return true;
    }

    fun loginWithEmail(email: String, password: String): Boolean {
        user = User("loggedInUser", arrayListOf(TaskItem("title", "subtitle", false)))
        return true;
    }

    fun logout(){
        user = null
    }

}