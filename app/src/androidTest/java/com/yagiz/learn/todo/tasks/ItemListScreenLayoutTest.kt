package com.yagiz.learn.todo.tasks

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.runner.AndroidJUnit4
import com.android.databinding.library.baseAdapters.BR
import com.yagiz.learn.todo.*
import com.yagiz.learn.todo.databinding.ListTaskBinding
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class ItemListScreenLayoutTest : BaseLayoutTest<ListTaskBinding, ItemListScreenViewModel>() {
    private lateinit var navigator: ITaskNavigator
    private lateinit var viewModel : ItemListScreenViewModel
    private lateinit var tasksRepository : TasksRepository

    @Before
    fun setup() {
        tasksRepository = DaggerTestRepositoryComponent.create().testTasksRepository()
        navigator = mock(ITaskNavigator::class.java)
        viewModel = ItemListScreenViewModel(tasksRepository,navigator)
    }

    @Test
    fun nullViewModelTest(){
        setLayout(R.layout.list_task, BR.viewModel, null)
        onView(withId(R.id.list_todo_rv)).check(matches(RecyclerViewMatchers.withItemCount(0)))
    }

    @Test
    fun bindDataTest() {
        setLayout(R.layout.list_task, BR.viewModel, viewModel)
        onView(withId(R.id.list_todo_rv)).check(matches(RecyclerViewMatchers.withItemCount(1)))
    }

}

