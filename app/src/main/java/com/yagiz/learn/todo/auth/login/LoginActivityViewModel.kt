package com.yagiz.learn.todo.auth.login

import android.databinding.Observable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.yagiz.learn.todo.api.ApiClient
import com.yagiz.learn.todo.api.AuthApiClient
import com.yagiz.learn.todo.auth.IAuthNavigator
import com.yagiz.learn.todo.base.viewmodel.getDoneViewModel
import javax.inject.Inject

class LoginActivityViewModel : getDoneViewModel() {

    @Inject
    lateinit var apiClient: ApiClient

    @Inject
    lateinit var navigator: IAuthNavigator

    private lateinit var authApiClient: AuthApiClient

    val loginButtonEnabled: ObservableBoolean = ObservableBoolean(false)
    val email: ObservableField<String> = ObservableField("")
    val password: ObservableField<String> = ObservableField("")

    override fun inject() {
        viewModelComponent.inject(this)
    }

    override fun setup() {
        super.setup()
        authApiClient = apiClient.auth

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
        navigator.onProceedToRegister()
    }

    fun onForgotPasswordClicked() {
        navigator.onForgotPassword()
    }
}
