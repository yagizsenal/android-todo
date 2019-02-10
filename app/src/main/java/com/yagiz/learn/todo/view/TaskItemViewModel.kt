package com.yagiz.learn.todo.view

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.yagiz.learn.todo.model.TaskItem
import com.yagiz.learn.todo.navigator.ITaskNavigator

open class TaskItemViewModel(private val navigator: ITaskNavigator) : ViewModel() {

    private val taskItem: MutableLiveData<TaskItem> = MutableLiveData()

    val title: String?
        get() = taskItem.value?.title


    val content: String?
        get() = taskItem.value?.content

    var showCheck: Boolean
        get() = taskItem.value?.isCompleted == true
        set(value) {
            if (taskItem.value?.isCompleted == value) return
            taskItem.value?.isCompleted = value
        }

    fun setModel(model: TaskItem) {
        taskItem.value = model
    }

    fun onLongClickTask(): Boolean {
        navigator.openEditTaskFragment(taskItem.value!!)
        return true
    }
}
