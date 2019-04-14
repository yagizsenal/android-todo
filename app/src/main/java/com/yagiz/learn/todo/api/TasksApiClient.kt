package com.yagiz.learn.todo.api

import javax.inject.Inject

open class TasksApiClient @Inject constructor(val authClient: AuthApiClient) {

    open fun getTasks() {

    }
}