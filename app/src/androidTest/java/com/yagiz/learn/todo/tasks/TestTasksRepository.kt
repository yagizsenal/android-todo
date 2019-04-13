package com.yagiz.learn.todo.tasks

import com.yagiz.learn.todo.api.TestTasksApiClient
import com.yagiz.learn.todo.livedata.DataState
import com.yagiz.learn.todo.livedata.MutableStatefulLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestTasksRepository @Inject constructor(private val tasksApiClient: TestTasksApiClient) : TasksRepository(tasksApiClient) {

    override fun getTasks(): MutableStatefulLiveData<ArrayList<TaskItem>> {
        val tasks = MutableStatefulLiveData(DataState.STATE_LOADED, arrayListOf(TaskItem("task1", "subtitle1", false)))

        //client.getTasks()


//        Handler().postDelayed({
//            tasks.postValue(DataState.STATE_LOADED, arrayListOf(TaskItem("title1", "subtitle1", false), TaskItem("title2", "subtitle2", true)))
//        }, 2500)

        return tasks
    }
}

