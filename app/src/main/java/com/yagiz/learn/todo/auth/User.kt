package com.yagiz.learn.todo.auth

import com.yagiz.learn.todo.tasks.TaskItem

data class User(
        val username: String,
        val tasks: ArrayList<TaskItem>
)

