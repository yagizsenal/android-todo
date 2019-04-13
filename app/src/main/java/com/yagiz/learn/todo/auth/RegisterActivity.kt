package com.yagiz.learn.todo.auth

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.yagiz.learn.todo.tasks.TasksActivity
import com.yagiz.learn.todo.R
import com.yagiz.learn.todo.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), IAuthNavigator {
    override fun signInWithEmailAndPass(email: String, password: String) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val TAG = "RegisterActivity"

    private lateinit var auth: FirebaseAuth
    override fun registerWithEmailAndPass(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        proceedToMainActivity()
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, task.exception?.message
                                ?: "Authentication failed", Toast.LENGTH_SHORT).show()
                    }
                }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            proceedToMainActivity()
            return
        }

        val viewModel = RegisterActivityViewModel(this)
        val binding = DataBindingUtil.setContentView<ActivityRegisterBinding>(this, R.layout.activity_register)
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }

    private fun proceedToMainActivity() {
        startActivity(Intent(this, TasksActivity::class.java))
        finish()
    }
}