package com.yagiz.learn.todo.tasks

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.yagiz.learn.todo.R
import com.yagiz.learn.todo.api.ApiClient
import com.yagiz.learn.todo.auth.login.LoginActivity
import com.yagiz.learn.todo.base.repository.RepositoryManager
import com.yagiz.learn.todo.databinding.ListTaskBinding
import com.yagiz.learn.todo.getDoneActivity
import javax.inject.Inject

class TasksActivity : getDoneActivity(), ITaskNavigator {
    private val TAG = "TasksActivity"

    @Inject
    lateinit var repositoryManager: RepositoryManager

    @Inject
    lateinit var apiClient: ApiClient

    override fun openEditTaskFragment(task: TaskItem) {
        //todo
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val auth = apiClient.auth

        if (auth.user == null) {
            startLoginActivity()
            finish()
        }

        val viewModel = ItemListScreenViewModel(repositoryManager.tasks, this)
        val binding = DataBindingUtil.setContentView<ListTaskBinding>(this, R.layout.list_task)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }

    override fun inject() {
        activityComponent.inject(this)
    }

    private fun startLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

}
