package com.yagiz.learn.todo.tasks

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.Observer
import com.yagiz.learn.todo.BaseLiveDataTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class TaskItemViewModelTest : BaseLiveDataTest() {

    private lateinit var model: TaskItem
    private lateinit var navigator: ITaskNavigator
    private lateinit var lifecycleOwner: LifecycleOwner
    private lateinit var lifecycleRegistry: LifecycleRegistry

    @Before
    fun setup() {
        model = TaskItem(TITLE, CONTENT, false)
        navigator = mock(ITaskNavigator::class.java)
        lifecycleOwner = mock(LifecycleOwner::class.java)
        lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)
    }

    @Test
    fun setModelTest() {
        val viewModel = TaskItemViewModel(navigator)
        viewModel.setModel(model)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
        viewModel.content.observe(lifecycleOwner, Observer {
            assertThat(it,`is`(CONTENT))
        })
        viewModel.showCheck.observe(lifecycleOwner, Observer {
            assertThat(it,`is`(false))
        })
        viewModel.title.observe(lifecycleOwner, Observer {
            assertThat(it,`is`(TITLE))
        })
    }

    companion object {
        private const val CONTENT = "content"
        private const val TITLE = "title"
    }
}