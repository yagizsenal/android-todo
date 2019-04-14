package com.yagiz.learn.todo.base.repository

import com.yagiz.learn.todo.tasks.TasksRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryManager @Inject constructor(val tasks: TasksRepository)

