package com.yagiz.learn.todo.auth.login

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import com.yagiz.learn.todo.BR
import com.yagiz.learn.todo.BaseLayoutTest
import com.yagiz.learn.todo.R
import com.yagiz.learn.todo.api.AuthApiClient
import com.yagiz.learn.todo.databinding.ActivityLoginBinding
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class LoginActivityViewModelLayoutTest : BaseLayoutTest<ActivityLoginBinding, LoginActivityViewModel>() {
    private lateinit var viewModel: LoginActivityViewModel
    private lateinit var authApiClient: AuthApiClient
    private lateinit var navigator: ILoginActivityNavigator

    @Before
    fun setup() {
        authApiClient = mock(AuthApiClient::class.java)
        navigator = mock(ILoginActivityNavigator::class.java)
        viewModel = LoginActivityViewModel(authApiClient, navigator)
        setLayout(R.layout.activity_login, BR.viewModel, viewModel)
    }

    @Test
    fun nullViewModelTest() {
        setLayout(R.layout.activity_login, BR.viewModel, null)

        onView(withId(R.id.et_email)).check(matches(withText("")))
        onView(withId(R.id.et_password)).check(matches(withText("")))
        onView(withId(R.id.tv_login)).check(matches(not(isEnabled())))
    }

    @Test
    fun bindEmailTest() {
        viewModel.email.set(EMAIL)
        onView(withId(R.id.et_email)).check(matches(withText(EMAIL)))
    }

    @Test
    fun bindPasswordTest() {
        viewModel.password.set(PASSWORD)
        onView(withId(R.id.et_password)).check(matches(withText(PASSWORD)))
    }

    @Test
    fun bindLoginButtonEnabledTest() {
        viewModel.password.set(PASSWORD)
        viewModel.email.set(EMAIL)
        onView(withId(R.id.tv_login)).perform(click())
        verify(authApiClient).loginWithEmail(EMAIL, PASSWORD)
    }

    @Test
    fun forgotPasswordTest() {
        onView(withId(R.id.tv_forgot_password)).perform(click())
        verify(navigator).onForgotPassword()
    }

    @Test
    fun googleSignInTest() {
        onView(withId(R.id.tv_connect_with_google)).perform(click())
        verify(authApiClient).signInWithGoogle()
    }

    @Test
    fun registerNowTest() {
        onView(withId(R.id.tv_register_now)).perform(click())
        verify(navigator).onRegister()
    }

    companion object {
        private const val EMAIL = "email"
        private const val PASSWORD = "password"
    }
}
