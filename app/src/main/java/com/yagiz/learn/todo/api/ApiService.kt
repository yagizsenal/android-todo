package com.yagiz.learn.todo.api

import javax.inject.Singleton

@Singleton
class ApiService {

    var isConnected = false
        private set

    fun connect(): Boolean {
        isConnected = true
        return true
    }

}