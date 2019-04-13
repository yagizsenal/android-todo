package com.yagiz.learn.todo.api

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface TestApiComponent : ApiComponent {
    fun testAuthApiClient(): TestAuthApiClient
    fun testTasksApiClient(): TestTasksApiClient
}