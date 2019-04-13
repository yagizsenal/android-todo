package com.yagiz.learn.todo

import com.yagiz.learn.todo.tasks.TasksRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface RepositoryComponent {
    fun tasks(): TasksRepository
}