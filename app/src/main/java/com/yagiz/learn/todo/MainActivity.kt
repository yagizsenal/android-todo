package com.yagiz.learn.todo

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.yagiz.learn.todo.databinding.ListTaskBinding
import com.yagiz.learn.todo.model.TaskItem
import com.yagiz.learn.todo.navigator.ITaskNavigator
import com.yagiz.learn.todo.provider.TaskItemProvider
import com.yagiz.learn.todo.view.ItemListScreenViewModel

class MainActivity : AppCompatActivity(), ITaskNavigator {
    private val TAG= "MainActivity"
    override fun openEditTaskFragment(task: TaskItem) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tasks = TaskItemProvider().getTasks()
        val viewModel = ItemListScreenViewModel(this)
        viewModel.setModel(listOf(TaskItem("Initial","Item",false)))
        val binding = DataBindingUtil.setContentView<ListTaskBinding>(this, R.layout.list_task)
        tasks.observe(this, Observer {
            if (it != null) {
                Log.d(TAG,"Updating viewModel")
                binding.viewModel?.setModel(it)
                binding.executePendingBindings()
            }
        })
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }
}
