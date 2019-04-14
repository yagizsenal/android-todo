package com.yagiz.learn.todo

import android.app.Application
import android.content.Context
import com.yagiz.learn.todo.api.ApiClient
import com.yagiz.learn.todo.base.application.ApplicationComponent
import com.yagiz.learn.todo.base.application.ApplicationModule
import com.yagiz.learn.todo.base.application.DaggerApplicationComponent
import com.yagiz.learn.todo.base.repository.RepositoryManager
import javax.inject.Inject

class getDoneApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
        private set

    @Inject
    lateinit var repositoryManager: RepositoryManager

    @Inject
    lateinit var apiClient: ApiClient


    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()

        applicationComponent.inject(this)
    }

    companion object {
        fun get(context: Context): getDoneApplication = context.applicationContext as getDoneApplication
    }
}

