package com.yagiz.learn.todo.view

import com.yagiz.learn.todo.BaseLiveDataTest
import com.yagiz.learn.todo.model.TodoItem
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class TodoItemViewModelTest : BaseLiveDataTest() {

    private lateinit var model: TodoItem

    @Before
    fun setup() {
        model = TodoItem(
            TITLE,
            CONTENT, false)
    }

    @Test
    fun setModelTest() {
        val viewModel = TodoItemViewModel()
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