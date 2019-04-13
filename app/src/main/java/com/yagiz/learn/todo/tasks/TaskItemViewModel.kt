package com.yagiz.learn.todo.tasks

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel

open class TaskItemViewModel(private val navigator: ITaskNavigator) : ViewModel() {

    private val taskItem: MutableLiveData<TaskItem> = MutableLiveData()

    val title: LiveData<String?> = Transformations.map(taskItem) { it.title }

    val content: LiveData<String?> = Transformations.map(taskItem) { it.content }

    var showCheck: LiveData<Boolean> = Transformations.map(taskItem) { it.isCompleted }

    fun setModel(model: TaskItem) {
        this.taskItem.value = model
    }

    fun onLongClickTask(): Boolean {
        navigator.openEditTaskFragment(taskItem.value!!)
        return true
    }

    fun onCheckedChanged() {

    }
}
