package com.yagiz.learn.todo.auth.login

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yagiz.learn.todo.R
import com.yagiz.learn.todo.api.DaggerApiComponent
import com.yagiz.learn.todo.databinding.ActivityLoginBinding
import com.yagiz.learn.todo.tasks.TasksActivity

class LoginActivity : AppCompatActivity(), ILoginActivityNavigator {
    override fun onRegister() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onForgotPassword() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apiComponent = DaggerApiComponent.create()
        val auth = apiComponent.authClient()

        if (auth.user != null) {
            proceedToMainActivity()
            return
        }

        val viewModel = LoginActivityViewModel(auth, this)
        val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel


    }

    private fun proceedToMainActivity() {
        startActivity(Intent(this, TasksActivity::class.java))
        finish()
    }

}
