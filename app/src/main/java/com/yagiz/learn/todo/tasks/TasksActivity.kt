package com.yagiz.learn.todo.tasks

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yagiz.learn.todo.DaggerRepositoryComponent
import com.yagiz.learn.todo.R
import com.yagiz.learn.todo.databinding.ListTaskBinding

class TasksActivity : AppCompatActivity(), ITaskNavigator {
    private val TAG = "TasksActivity"
    override fun openEditTaskFragment(task: TaskItem) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tasksRepository = DaggerRepositoryComponent.builder().build().tasks()
        val viewModel = ItemListScreenViewModel(tasksRepository,this)
        val binding = DataBindingUtil.setContentView<ListTaskBinding>(this, R.layout.list_task)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }
}
