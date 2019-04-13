package com.yagiz.learn.todo.api

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestTasksApiClient @Inject constructor(val authApiClient: TestAuthApiClient) : TasksApiClient(authApiClient) {

    override fun getTasks() {
        super.getTasks()
    }

}