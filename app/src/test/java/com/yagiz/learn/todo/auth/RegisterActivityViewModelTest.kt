package com.yagiz.learn.todo.auth

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class RegisterActivityViewModelTest {

    private lateinit var navigator: IAuthNavigator
    private lateinit var viewModel: RegisterActivityViewModel

    @Before
    fun setup() {
        navigator = mock(IAuthNavigator::class.java)
        viewModel = RegisterActivityViewModel(navigator)
    }


    @Test
    fun setEmailTest() {
        viewModel.email.set("Email")
        assertThat(viewModel.email.get(), `is`("Email"))
    }

    @Test
    fun setPasswordTest() {
        viewModel.password.set("Password")
        assertThat(viewModel.password.get(), `is`("Password"))
    }

    @Test
    fun setSignInButtonEnabledTest() {
        viewModel.email.set("Email")
        viewModel.password.set("Password")
        assertThat(viewModel.registerButtonEnabled.get(), `is`(true))
    }

}

