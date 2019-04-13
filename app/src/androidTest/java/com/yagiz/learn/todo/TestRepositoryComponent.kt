package com.yagiz.learn.todo

import com.yagiz.learn.todo.tasks.TestTasksRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface TestRepositoryComponent : RepositoryComponent {
    fun testTasksRepository(): TestTasksRepository
}
