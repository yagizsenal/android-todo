package com.yagiz.learn.todo.auth

import android.arch.lifecycle.ViewModel
import android.databinding.Observable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField

class RegisterActivityViewModel(val navigator: IRegisterNavigator) : ViewModel() {

    val registerButtonEnabled: ObservableBoolean = ObservableBoolean(false)
    var email: ObservableField<String> = ObservableField()
    var password: ObservableField<String> = ObservableField()

    init {
        val callback = object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if (password.get() == "" || email.get() == "") {
                    updateRegisterButtonEnabled(false)
                    return
                }
                updateRegisterButtonEnabled(true)
            }
        }
        callback.let {
            email.addOnPropertyChangedCallback(it)
            password.addOnPropertyChangedCallback(it)
        }
    }


    private fun updateRegisterButtonEnabled(value: Boolean) {
        with(registerButtonEnabled) {
            set(value)
            notifyChange()
        }
    }

    fun onRegisterButtonClicked() {
        navigator.signInWithEmail(email.get()!!, password.get()!!)
    }

}