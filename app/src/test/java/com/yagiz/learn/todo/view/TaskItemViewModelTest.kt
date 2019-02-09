package com.yagiz.learn.todo.view

import com.yagiz.learn.todo.BaseLiveDataTest
import com.yagiz.learn.todo.model.TaskItem
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class TaskItemViewModelTest : BaseLiveDataTest() {

    private lateinit var model: TaskItem

    @Before
    fun setup() {
        model = TaskItem(
            TITLE,
            CONTENT, false)
    }

    @Test
    fun setModelTest() {
        val viewModel = TaskItemViewModel()
        viewModel.setModel(model)
        assertThat(viewModel.content, `is`(CONTENT))
        assertThat(viewModel.showCheck, `is`(false))
        assertThat(viewModel.title, `is`(TITLE))
    }

    companion object {
        private const val CONTENT = "content"
        private const val TITLE = "title"
    }
}