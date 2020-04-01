package com.yagiz.learn.todo.base.viewmodel

import android.arch.lifecycle.ViewModel

abstract class getDoneViewModel : ViewModel() {

    lateinit var viewModelComponent: ViewModelComponent

    abstract fun inject()

    open fun setup() {
        viewModelComponent = DaggerViewModelComponent.builder()
                //.applicationComponent(getDoneApplication.get(this.).applicationComponent)
                // todo seperate contextless modules from applicationComponent
                .viewModelModule(ViewModelModule(this))
                .build()
        inject()
    }

    init {
        this.setup()
    }
}
