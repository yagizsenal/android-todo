package com.yagiz.learn.todo

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import com.yagiz.learn.todo.databinding.ItemTodoBinding
import com.yagiz.learn.todo.model.TodoItem
import com.yagiz.learn.todo.view.TodoItemViewModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TodoItemViewModelLayoutTest : BaseLayoutTest<ItemTodoBinding, TodoItemViewModel>() {

    private lateinit var model : TodoItem

    @Before
    fun setup(){
        model = TodoItem(TITLE,CONTENT,false)
    }

    @Test
    fun bindTitleTest() {
        val viewModel = TodoItemViewModel()
        viewModel.setModel(model)
        setLayout(R.layout.item_todo, BR.viewModel, viewModel)
        onView(withId(R.id.item_todo_title)).check(matches(withText(TITLE)))
    }

    @Test
    fun bindContentTest(){
        val viewModel = TodoItemViewModel()
        viewModel.setModel(model)
        setLayout(R.layout.item_todo, BR.viewModel, viewModel)
        onView(withId(R.id.item_todo_content)).check(matches(withText(CONTENT)))
    }

    @Test
    fun bindShowCheckTest(){
        val viewModel = TodoItemViewModel()
        viewModel.setModel(model)
        setLayout(R.layout.item_todo, BR.viewModel, viewModel)
        onView(withId(R.id.item_todo_completed)).check(matches(isNotChecked()))
    }

    @Test
    fun completeTodoTest(){
        val viewModel = TodoItemViewModel()
        viewModel.setModel(model)
        setLayout(R.layout.item_todo,BR.viewModel,viewModel)
        onView(withId(R.id.item_todo_completed)).perform(click()).check(matches(isChecked()))
    }

    companion object {
        private const val TITLE = "title"
        private const val CONTENT = "content"
    }

}
