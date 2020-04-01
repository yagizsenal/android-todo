package com.yagiz.learn.todo.base.viewmodel

import com.yagiz.learn.todo.auth.AuthNavigator
import com.yagiz.learn.todo.auth.IAuthNavigator
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(val viewModel: getDoneViewModel) {

    @Provides
    fun provideViewModel(): getDoneViewModel {
        return viewModel
    }

    @Provides
    fun provideAuthNavigator(): IAuthNavigator {
        return AuthNavigator()
    }

}

