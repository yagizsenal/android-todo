package com.yagiz.learn.todo.tasks

import com.yagiz.learn.todo.tasks.TaskItem

interface ITaskNavigator {
    fun openEditTaskFragment(task : TaskItem)
}