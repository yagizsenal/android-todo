package com.yagiz.learn.todo.view

import com.yagiz.learn.todo.model.TaskItem

interface ITaskNavigator {
    fun openEditTaskFragment(task : TaskItem)
}