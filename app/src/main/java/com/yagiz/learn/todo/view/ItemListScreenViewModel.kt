package com.yagiz.learn.todo.view

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.*
import com.yagiz.learn.todo.model.TodoItem

class ItemListScreenViewModel : ViewModel() {

    private var data: ObservableList<TodoItem> = ObservableArrayList()

    val todoList: List<TodoItem>
        get()= data

    fun setModel(data: List<TodoItem>) {
        this.data.clear()
        this.data.addAll(data)
    }

}

