package com.yagiz.learn.todo.api

import com.yagiz.learn.todo.livedata.DataState
import com.yagiz.learn.todo.livedata.MutableStatefulLiveData
import com.yagiz.learn.todo.tasks.TaskItem
import javax.inject.Inject

open class TasksApiClient @Inject constructor(private val authClient: AuthApiClient) {

    open fun getTasks() {

    }
}