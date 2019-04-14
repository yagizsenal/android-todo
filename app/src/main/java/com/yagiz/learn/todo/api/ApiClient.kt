package com.yagiz.learn.todo.api

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiClient @Inject constructor(val auth: AuthApiClient, val tasks: TasksApiClient)
