package com.yagiz.learn.todo.base.activity

import com.yagiz.learn.todo.auth.login.LoginActivity
import com.yagiz.learn.todo.auth.register.RegisterActivity
import com.yagiz.learn.todo.base.ActivityScope
import com.yagiz.learn.todo.base.application.ApplicationComponent
import com.yagiz.learn.todo.tasks.TasksActivity
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent {

    fun inject(activity: TasksActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: RegisterActivity)

}