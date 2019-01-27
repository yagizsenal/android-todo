package com.yagiz.learn.todo.view

import com.yagiz.learn.todo.BaseLiveDataTest
import com.yagiz.learn.todo.model.TodoItem
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class ItemListScreenViewModelTest: BaseLiveDataTest(){

    private lateinit var data: List<TodoItem>

    @Before
    fun setup(){
        data = listOf(TodoItem("Title1","Content1",false),TodoItem("Title2","Content2",true))
    }

    @Test
    fun setModelTest(){
        val viewModel = ItemListScreenViewModel()
        viewModel.setModel(data)
        assertThat(viewModel.todoList,`is`(data))
    }

}
