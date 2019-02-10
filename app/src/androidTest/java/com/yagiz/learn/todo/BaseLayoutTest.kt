package com.yagiz.learn.todo

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.ViewModel
import android.content.Intent
import android.databinding.ViewDataBinding
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.intercepting.SingleActivityFactory
import org.junit.Rule
import org.junit.rules.RuleChain

abstract class BaseLayoutTest<DB : ViewDataBinding, VM : ViewModel> {

    private lateinit var activity: LayoutTestActivity<DB, VM>

    private val factory = object : SingleActivityFactory<LayoutTestActivity<*, *>>(LayoutTestActivity::class.java) {
        override fun create(intent: Intent?): LayoutTestActivity<DB, VM> {
            activity = LayoutTestActivity()
            return activity
        }

    }

    val activityTestRule = ActivityTestRule(factory, true, true)

    @Rule
    @JvmField
    val rule = RuleChain.outerRule(InstantTaskExecutorRule()).around(activityTestRule)!!


    fun setLayout(layoutId: Int, variable: Int, value: VM?) {
        activity.setLayoutBindings(layoutId, variable, value)
    }

}
