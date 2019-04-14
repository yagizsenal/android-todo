package com.yagiz.learn.todo.base.application

import android.app.Application
import android.content.Context
import com.yagiz.learn.todo.base.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val app: Application) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context {
        return app
    }

    @Provides
    fun provideApplication(): Application {
        return app
    }

}