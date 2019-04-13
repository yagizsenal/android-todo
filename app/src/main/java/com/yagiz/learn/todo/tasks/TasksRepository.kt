package com.yagiz.learn.todo.tasks

import android.os.Handler
import com.yagiz.learn.todo.api.TasksApiClient
import com.yagiz.learn.todo.livedata.DataState
import com.yagiz.learn.todo.livedata.MutableStatefulLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class TasksRepository @Inject constructor(private val client: TasksApiClient) {

    open fun getTasks(): MutableStatefulLiveData<ArrayList<TaskItem>> {
        val tasks = MutableStatefulLiveData<ArrayList<TaskItem>>(DataState.STATE_LOADING, arrayListOf())

        //client.getTasks()

        Handler().postDelayed({
            tasks.postValue(DataState.STATE_LOADED, arrayListOf(TaskItem("title1", "subtitle1", false), TaskItem("title2", "subtitle2", true)))
        }, 2500)

        return tasks
    }

}