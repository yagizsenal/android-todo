package com.yagiz.learn.todo.view

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.runner.AndroidJUnit4
import com.android.databinding.library.baseAdapters.BR
import com.yagiz.learn.todo.BaseLayoutTest
import com.yagiz.learn.todo.R
import com.yagiz.learn.todo.RecyclerViewMatchers
import com.yagiz.learn.todo.databinding.ListTaskBinding
import com.yagiz.learn.todo.model.TaskItem
import com.yagiz.learn.todo.navigator.ITaskNavigator
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class ItemListScreenLayoutTest : BaseLayoutTest<ListTaskBinding, ItemListScreenViewModel>() {
    private lateinit var list: List<TaskItem>
    private lateinit var navigator: ITaskNavigator
    private lateinit var viewModel : ItemListScreenViewModel

    @Before
    fun setup() {
        list = listOf(TaskItem("Title1", "Content1", false), TaskItem("Title2", "Content2", true))
        navigator = mock(ITaskNavigator::class.java)
        viewModel = ItemListScreenViewModel(navigator)
    }

    @Test
    fun nullViewModelTest(){
        setLayout(R.layout.list_task, BR.viewModel, null)
        onView(withId(R.id.list_todo_rv)).check(matches(RecyclerViewMatchers.withItemCount(0)))
    }

    @Test
    fun bindDataTest() {
        viewModel.setModel(list)
        setLayout(R.layout.list_task, BR.viewModel, viewModel)
        onView(withId(R.id.list_todo_rv)).check(matches(RecyclerViewMatchers.withItemCount(2)))
    }

}

