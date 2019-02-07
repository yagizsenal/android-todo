package com.yagiz.learn.todo.view

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.yagiz.learn.todo.model.TaskItem

open class TaskItemViewModel : ViewModel() {

    private val taskItem: ObservableField<TaskItem> = ObservableField()

    val title: String?
        get() = taskItem.get()?.title


    val content: String?
        get() = taskItem.get()?.content

    var showCheck: Boolean
        get() = taskItem.get()?.isCompleted == true
        set(value){
            if (taskItem.get()?.isCompleted == value) return
            taskItem.get()?.isCompleted = value
        }

    fun setModel(model: TaskItem) {
        taskItem.set(model)
    }
}
