package com.yagiz.learn.todo.view

import android.arch.lifecycle.ViewModel
import android.databinding.*
import com.yagiz.learn.todo.model.TaskItem

class ItemListScreenViewModel(val navigator: ITaskNavigator) : ViewModel() {

    private var data: ObservableList<TaskItem> = ObservableArrayList<TaskItem>()

    val taskList: List<TaskItem>
        get()= data

    fun setModel(data: List<TaskItem>) {
        this.data.clear()
        this.data.addAll(data)
    }

}

