package com.yagiz.learn.todo.view

import android.databinding.ObservableField
import com.yagiz.learn.todo.navigator.ISignInNavigator
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class EmailSignInActivityViewModelTest {

    private lateinit var navigator: ISignInNavigator
    private lateinit var viewModel: EmailSignInActivityViewModel

    @Before
    fun setup() {
        navigator = mock(ISignInNavigator::class.java)
        viewModel = EmailSignInActivityViewModel(navigator)
    }


    @Test
    fun setEmailTest() {
        viewModel.email = ObservableField("Email")
        assertThat(viewModel.email.get(), `is`("Email"))
    }

    @Test
    fun setPasswordTest() {
        viewModel.password = ObservableField("Password")
        assertThat(viewModel.password.get(), `is`("Password"))
    }

    @Test
    fun setSignInButtonEnabledTest() {
        viewModel.email = ObservableField("Email")
        viewModel.password = ObservableField("Password")
        assertThat(viewModel.signInButtonEnabled.get(), `is`(true))
    }

}

