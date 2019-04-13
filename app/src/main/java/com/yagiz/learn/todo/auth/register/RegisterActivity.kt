package com.yagiz.learn.todo.auth.register

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yagiz.learn.todo.R
import com.yagiz.learn.todo.api.DaggerApiComponent
import com.yagiz.learn.todo.databinding.ActivityRegisterBinding
import com.yagiz.learn.todo.tasks.TasksActivity

class RegisterActivity : AppCompatActivity(), IRegisterNavigator {
    override fun onRegisterSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val TAG = "RegisterActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apiComponent = DaggerApiComponent.create()
        val auth = apiComponent.authClient()
        val viewModel = RegisterActivityViewModel(auth, this)
        val binding = DataBindingUtil.setContentView<ActivityRegisterBinding>(this, R.layout.activity_register)
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }

    private fun proceedToMainActivity() {
        startActivity(Intent(this, TasksActivity::class.java))
        finish()
    }
}