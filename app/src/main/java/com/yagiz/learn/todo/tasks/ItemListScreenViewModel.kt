package com.yagiz.learn.todo.tasks

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.yagiz.learn.todo.livedata.MutableStatefulLiveData

class ItemListScreenViewModel(private val tasksRepository: TasksRepository, val navigator: ITaskNavigator) : ViewModel() {
    private val taskListLiveData: MutableStatefulLiveData<ArrayList<TaskItem>> = tasksRepository.getTasks()
    val taskList: LiveData<ArrayList<TaskItem>> = Transformations.map(taskListLiveData) { it.data }
}

