package com.yagiz.learn.todo.view

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.databinding.InverseMethod
import android.util.Log
import com.yagiz.learn.todo.model.TaskItem
import com.yagiz.learn.todo.navigator.ITaskNavigator

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
