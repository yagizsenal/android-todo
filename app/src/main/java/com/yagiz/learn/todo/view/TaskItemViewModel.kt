package com.yagiz.learn.todo.view

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.yagiz.learn.todo.model.TaskItem
import com.yagiz.learn.todo.navigator.ITaskNavigator

open class TaskItemViewModel(private val navigator: ITaskNavigator) : ViewModel() {

    private val taskItem: ObservableField<TaskItem> = ObservableField()

    val title: String?
        get() = taskItem.get()?.title


    val content: String?
        get() = taskItem.get()?.content

    var showCheck: Boolean
        get() = taskItem.get()?.isCompleted == true
        set(value) {
            if (taskItem.get()?.isCompleted == value) return
            taskItem.get()?.isCompleted = value
        }

    fun setModel(model: TaskItem) {
        taskItem.set(model)
    }

    fun onLongClickTask(): Boolean {
        navigator.openEditTaskFragment(taskItem.get()!!)
        return true
    }
}
