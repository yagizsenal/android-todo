package com.yagiz.learn.todo.api

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface ApiComponent {
    fun authClient(): AuthApiClient
    fun tasksClient(): TasksApiClient
}