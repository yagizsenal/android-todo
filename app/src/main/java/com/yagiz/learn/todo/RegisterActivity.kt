package com.yagiz.learn.todo

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.yagiz.learn.todo.databinding.ActivitySigninBinding
import com.yagiz.learn.todo.navigator.IRegisterNavigator
import com.yagiz.learn.todo.view.EmailSignInActivityViewModel

class RegisterActivity : AppCompatActivity(), IRegisterNavigator {

    private val TAG = "RegisterActivity"

    private lateinit var auth: FirebaseAuth
    override fun signInWithEmail(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        proceedToMainActivity()
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, task.exception?.message ?: "Authentication failed", Toast.LENGTH_SHORT).show()
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

        val viewModel = EmailSignInActivityViewModel(this)
        val binding = DataBindingUtil.setContentView<ActivitySigninBinding>(this, R.layout.activity_signin)
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }

    private fun proceedToMainActivity(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}