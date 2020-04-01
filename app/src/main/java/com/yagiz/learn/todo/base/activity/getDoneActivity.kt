package com.yagiz.learn.todo.base.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yagiz.learn.todo.base.application.getDoneApplication

abstract class getDoneActivity : AppCompatActivity() {

    lateinit var activityComponent: ActivityComponent
        private set

    abstract fun inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(getDoneApplication.get(this).applicationComponent)
                .activityModule(ActivityModule(this))
                .build()

        inject()

    }
}