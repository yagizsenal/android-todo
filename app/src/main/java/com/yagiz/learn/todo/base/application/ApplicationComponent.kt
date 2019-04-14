package com.yagiz.learn.todo.base.application

import android.app.Application
import android.content.Context
import com.yagiz.learn.todo.api.ApiClient
import com.yagiz.learn.todo.base.ApplicationContext
import com.yagiz.learn.todo.base.repository.RepositoryManager
import com.yagiz.learn.todo.getDoneApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: getDoneApplication)

    fun application(): Application

    @ApplicationContext
    fun context(): Context

    fun apiClient(): ApiClient

    fun repositoryManager(): RepositoryManager

}