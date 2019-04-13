package com.yagiz.learn.todo.auth

import com.yagiz.learn.todo.BaseLiveDataTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class LoginActivityViewModelTest: BaseLiveDataTest() {

    private lateinit var navigator: IAuthNavigator
    private lateinit var viewModel: LoginActivityViewModel

    @Before
    fun setup(){
        navigator = mock(IAuthNavigator::class.java)
        viewModel = LoginActivityViewModel(navigator)
    }

    @Test
    fun loginButtonEnabledTest(){
        viewModel.password.set(PASSWORD)
        assertThat(viewModel.loginButtonEnabled.get(),`is`(false))
        viewModel.email.set(EMAIL)
        assertThat(viewModel.loginButtonEnabled.get(),`is`(true))
    }

    @Test
    fun onLoginButtonClickedTest(){
        viewModel.password.set(PASSWORD)
        viewModel.email.set(EMAIL)
        viewModel.onLoginButtonClicked()
        verify(navigator).signInWithEmailAndPass(EMAIL, PASSWORD)
    }

    companion object {
        private const val PASSWORD = "password"
        private const val EMAIL = "email"
    }

}
