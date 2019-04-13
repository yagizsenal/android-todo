package com.yagiz.learn.todo.api

import com.yagiz.learn.todo.tasks.TaskItem
import com.yagiz.learn.todo.auth.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestAuthApiClient @Inject constructor() : AuthApiClient() {

    override fun loginWithEmail(email: String, password: String): Boolean {
        user = User("loggedInUser", arrayListOf(TaskItem("title", "subtitle", false)))
        return true
    }

    override fun register(email: String, username: String, password: String): Boolean {
        user = User("registeredUser", arrayListOf())
        return true
    }

    override fun signInWithGoogle(): Boolean {
        user = User("googleSignInUser", arrayListOf())
        return true
    }

}
