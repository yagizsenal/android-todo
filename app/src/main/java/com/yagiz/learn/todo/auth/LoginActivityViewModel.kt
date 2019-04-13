package com.yagiz.learn.todo.auth

import android.arch.lifecycle.ViewModel
import android.databinding.Observable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField

class LoginActivityViewModel(val navigator: IAuthNavigator) : ViewModel() {

    val loginButtonEnabled: ObservableBoolean = ObservableBoolean(false)
    val email: ObservableField<String> = ObservableField("")
    val password: ObservableField<String> = ObservableField("")

    init {
        val callback = object : Observable.OnPropertyChangedCallback() {

            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if (!email.get().isNullOrEmpty() && !password.get().isNullOrEmpty()){
                    updateLoginButtonEnabled(true)
                } else if (loginButtonEnabled.get()){
                    updateLoginButtonEnabled(false)
                }
            }
        }
        callback.let {
            email.addOnPropertyChangedCallback(it)
            password.addOnPropertyChangedCallback(it)
        }
    }

    private fun updateLoginButtonEnabled(value: Boolean) {
        with(loginButtonEnabled) {
            set(value)
            notifyChange()
        }
    }

    fun onLoginButtonClicked() {
        navigator.signInWithEmailAndPass(email.get()!!, password.get()!!)
    }
}
