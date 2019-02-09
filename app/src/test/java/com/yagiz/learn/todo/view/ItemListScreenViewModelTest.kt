package com.yagiz.learn.todo.view

import com.yagiz.learn.todo.BaseLiveDataTest
import com.yagiz.learn.todo.model.TaskItem
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class ItemListScreenViewModelTest: BaseLiveDataTest(){

    private lateinit var data: List<TaskItem>
    private lateinit var navigator: ITaskNavigator

    @Before
    fun setup(){
        data = listOf(TaskItem("Title1","Content1",false),TaskItem("Title2","Content2",true))
        navigator = mock(ITaskNavigator::class.java)
    }

    @Test
    fun setModelTest(){
        val viewModel = ItemListScreenViewModel(navigator)
        viewModel.setModel(data)
        assertThat(viewModel.taskList,`is`(data))
    }

}
