package com.yagiz.learn.todo.auth.login

import android.arch.lifecycle.ViewModel
import android.databinding.Observable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.yagiz.learn.todo.api.AuthApiClient

class LoginActivityViewModel(private val authApiClient: AuthApiClient, private val navigator: ILoginActivityNavigator) : ViewModel() {

    val loginButtonEnabled: ObservableBoolean = ObservableBoolean(false)
    val email: ObservableField<String> = ObservableField("")
    val password: ObservableField<String> = ObservableField("")

    init {
        val callback = object : Observable.OnPropertyChangedCallback() {

            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {

                fun updateLoginButtonEnabled(value: Boolean) {
                    with(loginButtonEnabled) {
                        set(value)
                        notifyChange()
                    }
                }

                if (!email.get().isNullOrEmpty() && !password.get().isNullOrEmpty()) {
                    updateLoginButtonEnabled(true)
                } else if (loginButtonEnabled.get()) {
                    updateLoginButtonEnabled(false)
                }
            }
        }
        callback.let {
            email.addOnPropertyChangedCallback(it)
            password.addOnPropertyChangedCallback(it)
        }
    }

    fun onLoginButtonClicked() {
        authApiClient.loginWithEmail(email.get()!!, password.get()!!)
    }

    fun onGoogleSignInClicked() {
        authApiClient.signInWithGoogle()

    }

    fun onRegisterButtonClicked() {
        navigator.onRegister()
    }

    fun onForgotPasswordClicked() {
        navigator.onForgotPassword()
    }
}
