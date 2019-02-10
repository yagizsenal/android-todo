package com.yagiz.learn.todo.view

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.android.databinding.library.baseAdapters.BR
import com.yagiz.learn.todo.BaseLayoutTest
import com.yagiz.learn.todo.R
import com.yagiz.learn.todo.RecyclerViewMatchers
import com.yagiz.learn.todo.databinding.ListTaskBinding
import com.yagiz.learn.todo.model.TaskItem
import com.yagiz.learn.todo.navigator.ITaskNavigator
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class ItemListScreenLayoutTest : BaseLayoutTest<ListTaskBinding, ItemListScreenViewModel>() {
    private lateinit var data: List<TaskItem>
    private lateinit var navigator: ITaskNavigator
    @Before
    fun setup() {
        data = listOf(TaskItem("Title1", "Content1", false), TaskItem("Title2", "Content2", true))
        navigator = mock(ITaskNavigator::class.java)
    }

    @Test
    fun bindDataTest() {
        val viewModel = ItemListScreenViewModel(navigator)
        viewModel.setModel(data)
        setLayout(R.layout.list_task, BR.viewModel, viewModel)
        onView(withId(R.id.list_todo_rv)).check(matches(RecyclerViewMatchers.withItemCount(2)))
}

}

