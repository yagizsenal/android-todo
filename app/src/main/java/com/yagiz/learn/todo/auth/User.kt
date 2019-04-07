package com.yagiz.learn.todo.auth

import com.yagiz.learn.todo.model.TaskItem

data class User(
        val username: String,
        val tasks: ArrayList<TaskItem>
)

