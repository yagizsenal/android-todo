package com.yagiz.learn.todo.base.activity

import android.app.Activity
import android.content.Context
import com.yagiz.learn.todo.base.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @ActivityContext
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideActivity(): Activity{
        return activity
    }
}
