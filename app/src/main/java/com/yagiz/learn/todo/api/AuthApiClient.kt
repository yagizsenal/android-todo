package com.yagiz.learn.todo.api

import com.yagiz.learn.todo.auth.User
import com.yagiz.learn.todo.tasks.TaskItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class AuthApiClient @Inject constructor() {

    var user: User? = null
        protected set

    open fun register(email: String, username: String, password: String): Boolean {
        user = User("registeredUser", arrayListOf())
        return true;
    }

    open fun signInWithGoogle(): Boolean {
        return true;
    }

    open fun loginWithEmail(email: String, password: String): Boolean {
        user = User("loggedInUser", arrayListOf(TaskItem("title", "subtitle", false)))
        return true;
    }

    fun logout() {
        user = null
    }

}