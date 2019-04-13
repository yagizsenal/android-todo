package com.yagiz.learn.todo.tasks

import com.yagiz.learn.todo.BaseLiveDataTest
import com.yagiz.learn.todo.livedata.DataState
import com.yagiz.learn.todo.livedata.MutableStatefulLiveData
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ItemListScreenViewModelTest : BaseLiveDataTest() {

    private lateinit var data: ArrayList<TaskItem>
    private lateinit var navigator: ITaskNavigator
    private lateinit var tasksRepository: TasksRepository

    @Before
    fun setup() {
        tasksRepository = mock(TasksRepository::class.java)
        data = arrayListOf(TaskItem("Title1", "Content1", false), TaskItem("Title2", "Content2", true))
        navigator = mock(ITaskNavigator::class.java)
    }

    @Test
    fun setModelTest() {
        `when`(tasksRepository.getTasks()).thenReturn(MutableStatefulLiveData(DataState.STATE_LOADED, data))
        val viewModel = ItemListScreenViewModel(tasksRepository, navigator)
        viewModel.taskList.observeForever {
            // Since the value of MediatorLiveData is instantiated lazily, the value will not be updated unless something observes it.
        }
        assertThat(viewModel.taskList.value, `is`(data))
    }

}
