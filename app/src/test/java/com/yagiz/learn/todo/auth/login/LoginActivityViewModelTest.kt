package com.yagiz.learn.todo.auth.login

import com.yagiz.learn.todo.BaseLiveDataTest
import com.yagiz.learn.todo.api.AuthApiClient
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class LoginActivityViewModelTest : BaseLiveDataTest() {

    private lateinit var authClient: AuthApiClient
    private lateinit var viewModel: LoginActivityViewModel
    private lateinit var navigator: ILoginActivityNavigator

    @Before
    fun setup() {
        authClient = mock(AuthApiClient::class.java)
        navigator = mock(ILoginActivityNavigator::class.java)
        viewModel = LoginActivityViewModel(authClient, navigator)
    }

    @Test
    fun loginButtonEnabledTest() {
        viewModel.password.set(PASSWORD)
        assertThat(viewModel.loginButtonEnabled.get(), `is`(false))
        viewModel.email.set(EMAIL)
        assertThat(viewModel.loginButtonEnabled.get(), `is`(true))
    }

    @Test
    fun onLoginButtonClickedTest() {
        viewModel.password.set(PASSWORD)
        viewModel.email.set(EMAIL)
        viewModel.onLoginButtonClicked()
        verify(authClient).loginWithEmail(EMAIL, PASSWORD)
    }

    @Test
    fun onGoogleSignInClickedTest() {
        viewModel.onGoogleSignInClicked()
        verify(authClient).signInWithGoogle()
    }

    @Test
    fun onRegisterButtonClickedTest() {
        viewModel.onRegisterButtonClicked()
        verify(navigator).onRegister()
    }

    @Test
    fun onForgotPasswordClicked() {
        viewModel.onForgotPasswordClicked()
        verify(navigator).onForgotPassword()
    }

    companion object {
        private const val PASSWORD = "password"
        private const val EMAIL = "email"
    }

}
