package com.yagiz.learn.todo

import android.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule

abstract class BaseLiveDataTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

}