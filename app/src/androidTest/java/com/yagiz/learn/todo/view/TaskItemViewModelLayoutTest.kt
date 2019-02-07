package com.yagiz.learn.todo.view

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import com.yagiz.learn.todo.BR
import com.yagiz.learn.todo.BaseLayoutTest
import com.yagiz.learn.todo.R
import com.yagiz.learn.todo.databinding.ItemTodoBinding
import com.yagiz.learn.todo.model.TaskItem
import org.hamcrest.CoreMatchers.`is`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TaskItemViewModelLayoutTest : BaseLayoutTest<ItemTodoBinding, TaskItemViewModel>() {

    private lateinit var model : TaskItem

    @Before
    fun setup(){
        model = TaskItem(
            TITLE,
            CONTENT,false)
    }

    @Test
    fun bindTitleTest() {
        val viewModel = TaskItemViewModel()
        viewModel.setModel(model)
        setLayout(
            R.layout.item_todo,
            BR.viewModel, viewModel)
        onView(withId(R.id.item_todo_title)).check(matches(withText(TITLE)))
    }

    @Test
    fun bindContentTest(){
        val viewModel = TaskItemViewModel()
        viewModel.setModel(model)
        setLayout(
            R.layout.item_todo,
            BR.viewModel, viewModel)
        onView(withId(R.id.item_todo_content)).check(matches(withText(CONTENT)))
    }

    @Test
    fun bindShowCheckTest(){
        val viewModel = TaskItemViewModel()
        viewModel.setModel(model)
        setLayout(
            R.layout.item_todo,
            BR.viewModel, viewModel)
        onView(withId(R.id.item_todo_completed)).check(matches(isNotChecked()))
    }

    @Test
    fun completeTodoTest(){
        val viewModel = TaskItemViewModel()
        viewModel.setModel(model)
        setLayout(
            R.layout.item_todo,
            BR.viewModel,viewModel)
        onView(withId(R.id.item_todo_completed)).perform(click()).check(matches(isChecked()))
        assertThat(viewModel.showCheck,`is`(true))
    }

    companion object {
        private const val TITLE = "title"
        private const val CONTENT = "content"
    }

}
