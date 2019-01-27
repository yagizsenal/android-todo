package com.yagiz.learn.todo.view

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.Observable
import android.databinding.ObservableField
import com.yagiz.learn.todo.model.TodoItem

open class TodoItemViewModel : ViewModel() {

    private val todoItem: ObservableField<TodoItem> = ObservableField()

    val title: String?
        get() = todoItem.get()?.title


    val content: String?
        get() = todoItem.get()?.content

    var showCheck: Boolean
        get() = todoItem.get()?.isCompleted == true
        set(value){
            if (todoItem.get()?.isCompleted == value) return
            todoItem.get()?.isCompleted = value
        }

    fun setModel(model: TodoItem) {
        todoItem.set(model)
    }
}
