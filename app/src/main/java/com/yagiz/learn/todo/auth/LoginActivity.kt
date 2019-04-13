package com.yagiz.learn.todo.auth

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.yagiz.learn.todo.tasks.TasksActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val auth = FirebaseAuth.getInstance()

        if (auth.currentUser != null) {
            proceedToMainActivity()
            return
        }

//        val viewModel = LoginActivityViewModel(this)


    }

    private fun proceedToMainActivity() {
        startActivity(Intent(this, TasksActivity::class.java))
        finish()
    }

}
