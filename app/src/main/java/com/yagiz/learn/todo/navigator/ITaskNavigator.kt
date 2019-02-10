package com.yagiz.learn.todo.navigator

import com.yagiz.learn.todo.model.TaskItem

interface ITaskNavigator {
    fun openEditTaskFragment(task : TaskItem)
}