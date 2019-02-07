package com.yagiz.learn.todo.view

import com.yagiz.learn.todo.BaseLiveDataTest
import com.yagiz.learn.todo.model.TaskItem
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class ItemListScreenViewModelTest: BaseLiveDataTest(){

    private lateinit var data: List<TaskItem>

    @Before
    fun setup(){
        data = listOf(TaskItem("Title1","Content1",false),TaskItem("Title2","Content2",true))
    }

    @Test
    fun setModelTest(){
        val viewModel = ItemListScreenViewModel()
        viewModel.setModel(data)
        assertThat(viewModel.taskList,`is`(data))
    }

}
