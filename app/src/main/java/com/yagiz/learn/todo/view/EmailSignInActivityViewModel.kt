package com.yagiz.learn.todo.view

import android.arch.lifecycle.ViewModel
import android.databinding.Observable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.yagiz.learn.todo.navigator.ISignInNavigator

class EmailSignInActivityViewModel(val navigator: ISignInNavigator) : ViewModel() {

    val signInButtonEnabled: ObservableBoolean = ObservableBoolean(false)
    var email: ObservableField<String> = ObservableField()
    var password: ObservableField<String> = ObservableField()

    init {
        val callback = object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if (password.get() == "" || email.get() == "") {
                    updateSignInButtonEnabled(false)
                    return
                }
                updateSignInButtonEnabled(true)
            }
        }
        callback.let {
            email.addOnPropertyChangedCallback(it)
            password.addOnPropertyChangedCallback(it)
        }
    }


    private fun updateSignInButtonEnabled(value: Boolean) {
        with(signInButtonEnabled) {
            set(value)
            notifyChange()
        }
    }

    fun onSignInButtonClicked() {
        navigator.signInWithEmail(email.get()!!, password.get()!!)
    }

}