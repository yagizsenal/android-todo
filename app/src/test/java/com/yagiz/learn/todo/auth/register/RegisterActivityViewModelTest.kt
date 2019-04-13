package com.yagiz.learn.todo.auth.register

import com.yagiz.learn.todo.api.AuthApiClient
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class RegisterActivityViewModelTest {

    private lateinit var apiClient: AuthApiClient
    private lateinit var viewModel: RegisterActivityViewModel
    private lateinit var navigator: IRegisterNavigator

    @Before
    fun setup() {
        apiClient = mock(AuthApiClient::class.java)
        navigator = mock(IRegisterNavigator::class.java)
        viewModel = RegisterActivityViewModel(apiClient, navigator)
    }


    @Test
    fun setEmailTest() {
        viewModel.email.set(EMAIL)
        assertThat(viewModel.email.get(), `is`(EMAIL))
    }

    @Test
    fun setPasswordTest() {
        viewModel.password.set(PASSWORD)
        assertThat(viewModel.password.get(), `is`(PASSWORD))
    }

    @Test
    fun setUsernameTest() {
        viewModel.username.set(USERNAME)
        assertThat(viewModel.username.get(), `is`(USERNAME))
    }

    @Test
    fun setSignInButtonEnabledTest() {
        viewModel.email.set(EMAIL)
        viewModel.password.set(PASSWORD)
        viewModel.username.set(USERNAME)
        assertThat(viewModel.signInButtonEnabled.get(), `is`(true))
    }

    @Test
    fun onRegisterClickedTest() {
        viewModel.email.set(EMAIL)
        viewModel.password.set(PASSWORD)
        viewModel.username.set(USERNAME)
        viewModel.onRegisterButtonClicked()
        verify(apiClient).register(USERNAME, EMAIL, PASSWORD)
    }

    @Test
    fun onGoogleSignInClickedTest() {
        viewModel.onGoogleSignInClicked()
        verify(apiClient).signInWithGoogle()
    }

    companion object {
        private const val EMAIL = "Email"
        private const val PASSWORD = "Password"
        private const val USERNAME = "Username"
    }

}

