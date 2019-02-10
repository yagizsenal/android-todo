package com.yagiz.learn.todo.view

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.longClick
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import com.yagiz.learn.todo.BR
import com.yagiz.learn.todo.BaseLayoutTest
import com.yagiz.learn.todo.R
import com.yagiz.learn.todo.databinding.ItemTaskBinding
import com.yagiz.learn.todo.model.TaskItem
import com.yagiz.learn.todo.navigator.ITaskNavigator
import org.hamcrest.CoreMatchers.`is`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class TaskItemViewModelLayoutTest : BaseLayoutTest<ItemTaskBinding, TaskItemViewModel>() {

    private lateinit var model: TaskItem
    private lateinit var navigator: ITaskNavigator

    @Before
    fun setup() {
        model = TaskItem(
                TITLE,
                CONTENT, false)
        navigator = mock(ITaskNavigator::class.java)
    }

    @Test
    fun bindTitleTest() {
        val viewModel = TaskItemViewModel(navigator)
        viewModel.setModel(model)
        setLayout(
                R.layout.item_task,
                BR.viewModel, viewModel)
        onView(withId(R.id.item_todo_title)).check(matches(withText(TITLE)))
    }

    @Test
    fun bindContentTest() {
        val viewModel = TaskItemViewModel(navigator)
        viewModel.setModel(model)
        setLayout(
                R.layout.item_task,
                BR.viewModel, viewModel)
        onView(withId(R.id.item_todo_content)).check(matches(withText(CONTENT)))
    }

    @Test
    fun bindShowCheckTest() {
        val viewModel = TaskItemViewModel(navigator)
        viewModel.setModel(model)
        setLayout(
                R.layout.item_task,
                BR.viewModel, viewModel)
        onView(withId(R.id.item_todo_completed)).check(matches(isNotChecked()))
    }

    @Test
    fun completeTodoTest() {
        val viewModel = TaskItemViewModel(navigator)
        viewModel.setModel(model)
        setLayout(R.layout.item_task, BR.viewModel, viewModel)
        onView(withId(R.id.item_todo_completed)).perform(click()).check(matches(isChecked()))
        assertThat(viewModel.showCheck, `is`(true))
    }

    @Test
    fun taskLongClickTest() {
        val viewModel = TaskItemViewModel(navigator)
        viewModel.setModel(model)
        setLayout(R.layout.item_task, BR.viewModel, viewModel)
        onView(withId(R.id.item_todo_rl_root)).perform(longClick())
        verify(navigator).openEditTaskFragment(model)
    }

    companion object {
        private const val TITLE = "title"
        private const val CONTENT = "content"
    }

}
