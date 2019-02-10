package com.yagiz.learn.todo.view

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.yagiz.learn.todo.model.TaskItem
import com.yagiz.learn.todo.navigator.ITaskNavigator

class ItemListScreenViewModel(val navigator: ITaskNavigator) : ViewModel() {

     val taskList = MutableLiveData<List<TaskItem>>()

    fun setModel(data: List<TaskItem>) {
        this.taskList.value = data
    }

}

