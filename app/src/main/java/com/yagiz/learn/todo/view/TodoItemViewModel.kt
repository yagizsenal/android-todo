package com.yagiz.learn.todo.view

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.yagiz.learn.todo.model.TodoItem

open class TodoItemViewModel : ViewModel() {

    private val todoItem: MutableLiveData<TodoItem> = MutableLiveData()

    var title: String?
        get() = todoItem.value?.title
        set(value) {
            todoItem.value?.title = value
        }

    var content: String?
        get() = todoItem.value?.content
        set(value) {
            todoItem.value?.content = value
        }

    var showCheck: Boolean
        get() = todoItem.value?.isCompleted == true
        set(value) {
            if (todoItem.value?.isCompleted == value) return
            todoItem.value?.isCompleted = value
        }

    fun setModel(model: TodoItem) {
        todoItem.postValue(model)
    }
}
