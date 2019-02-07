package com.yagiz.learn.todo.view

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.android.databinding.library.baseAdapters.BR
import com.yagiz.learn.todo.BaseLayoutTest
import com.yagiz.learn.todo.R
import com.yagiz.learn.todo.RecyclerViewMatchers
import com.yagiz.learn.todo.databinding.ListTodoBinding
import com.yagiz.learn.todo.model.TaskItem
import org.junit.Before
import org.junit.Test

class ItemListScreenLayoutTest : BaseLayoutTest<ListTodoBinding, ItemListScreenViewModel>() {
    private lateinit var data: List<TaskItem>
    @Before
    fun setup() {
        data = listOf(TaskItem("Title1", "Content1", false), TaskItem("Title2", "Content2", true))
    }

    @Test
    fun bindDataTest() {
        val viewModel = ItemListScreenViewModel()
        viewModel.setModel(data)
        setLayout(R.layout.list_todo, BR.viewModel, viewModel)
        onView(withId(R.id.list_todo_rv)).check(matches(RecyclerViewMatchers.withItemCount(2)))
    }

}

