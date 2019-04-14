package com.yagiz.learn.todo.auth.register

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.yagiz.learn.todo.R
import com.yagiz.learn.todo.api.ApiClient
import com.yagiz.learn.todo.databinding.ActivityRegisterBinding
import com.yagiz.learn.todo.getDoneActivity
import com.yagiz.learn.todo.tasks.TasksActivity
import javax.inject.Inject

class RegisterActivity : getDoneActivity(), IRegisterNavigator {
    private val TAG = "RegisterActivity"

    @Inject
    lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val auth = apiClient.auth
        val viewModel = RegisterActivityViewModel(auth, this)
        val binding = DataBindingUtil.setContentView<ActivityRegisterBinding>(this, R.layout.activity_register)
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }

    private fun proceedToMainActivity() {
        startActivity(Intent(this, TasksActivity::class.java))
        finish()
    }

    override fun inject() {
        activityComponent.inject(this)
    }

    override fun onRegisterSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}