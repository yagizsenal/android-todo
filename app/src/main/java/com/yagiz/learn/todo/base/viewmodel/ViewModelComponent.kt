package com.yagiz.learn.todo.base.viewmodel

import com.yagiz.learn.todo.auth.login.LoginActivityViewModel
import com.yagiz.learn.todo.base.ViewModelScope
import com.yagiz.learn.todo.base.application.ApplicationComponent
import com.yagiz.learn.todo.base.application.ApplicationModule
import dagger.Component

@ViewModelScope
@Component(modules = [ViewModelModule::class], dependencies = [ApplicationComponent::class])
interface ViewModelComponent {
    fun inject(viewModel: LoginActivityViewModel)
}

