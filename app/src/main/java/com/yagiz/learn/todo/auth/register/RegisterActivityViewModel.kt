package com.yagiz.learn.todo.auth.register

import android.arch.lifecycle.ViewModel
import android.databinding.Observable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.yagiz.learn.todo.api.AuthApiClient

class RegisterActivityViewModel(private val authApiClient: AuthApiClient, private val navigator: IRegisterNavigator) : ViewModel() {

    val signInButtonEnabled: ObservableBoolean = ObservableBoolean(false)
    var username: ObservableField<String> = ObservableField()
    var email: ObservableField<String> = ObservableField()
    var password: ObservableField<String> = ObservableField()

    init {
        val callback = object : Observable.OnPropertyChangedCallback() {

            private fun updateRegisterButtonEnabled(value: Boolean) {
                with(signInButtonEnabled) {
                    set(value)
                    notifyChange()
                }
            }

            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if (password.get() == "" || email.get() == "" || username.get() == "") {
                    updateRegisterButtonEnabled(false)
                    return
                }
                updateRegisterButtonEnabled(true)
            }
        }
        callback.let {
            email.addOnPropertyChangedCallback(it)
            password.addOnPropertyChangedCallback(it)
            username.addOnPropertyChangedCallback(it)
        }
    }

    fun onRegisterButtonClicked() {
        authApiClient.register(username.get()!!, email.get()!!, password.get()!!)
    }

    fun onGoogleSignInClicked() {
        authApiClient.signInWithGoogle()
    }

}