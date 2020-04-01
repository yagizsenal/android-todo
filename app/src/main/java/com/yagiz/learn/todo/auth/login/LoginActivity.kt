package com.yagiz.learn.todo.auth.login

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.yagiz.learn.todo.R
import com.yagiz.learn.todo.api.ApiClient
import com.yagiz.learn.todo.auth.register.RegisterActivity
import com.yagiz.learn.todo.base.activity.getDoneActivity
import com.yagiz.learn.todo.databinding.ActivityLoginBinding
import com.yagiz.learn.todo.tasks.TasksActivity
import javax.inject.Inject

class LoginActivity : getDoneActivity(), ILoginActivityNavigator {

    @Inject
    lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val auth = apiClient.auth

        if (auth.user != null) {
            startActivity(Intent(this, TasksActivity::class.java))
            finish()
            return
        }
        val viewModel = ViewModelProviders.of(this).get(LoginActivityViewModel::class.java)
        val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
    }

    override fun inject() {
        activityComponent.inject(this)
    }

    override fun onRegister() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    override fun onForgotPassword() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
