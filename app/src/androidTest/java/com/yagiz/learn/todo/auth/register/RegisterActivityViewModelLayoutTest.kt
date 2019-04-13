package com.yagiz.learn.todo.auth.register

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import com.yagiz.learn.todo.BR
import com.yagiz.learn.todo.BaseLayoutTest
import com.yagiz.learn.todo.R
import com.yagiz.learn.todo.api.AuthApiClient
import com.yagiz.learn.todo.databinding.ActivityRegisterBinding
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class RegisterActivityViewModelLayoutTest : BaseLayoutTest<ActivityRegisterBinding, RegisterActivityViewModel>() {
    private lateinit var viewModel: RegisterActivityViewModel
    private lateinit var authApiClient: AuthApiClient
    private lateinit var navigator: IRegisterNavigator

    @Before
    fun setup() {
        authApiClient = mock(AuthApiClient::class.java)
        navigator = mock(IRegisterNavigator::class.java)
        viewModel = RegisterActivityViewModel(authApiClient, navigator)
        setLayout(R.layout.activity_register, BR.viewModel, viewModel)
    }

    @Test
    fun nullViewModelTest() {
        setLayout(R.layout.activity_register, BR.viewModel, null)

        onView(withId(R.id.et_email)).check(matches(withText("")))
        onView(withId(R.id.et_password)).check(matches(withText("")))
        onView(withId(R.id.tv_signin)).check(matches(not(isEnabled())))
    }

    @Test
    fun bindEmailTest() {
        onView(withId(R.id.et_email)).perform(replaceText(EMAIL))
        assertThat(viewModel.email.get(), `is`(EMAIL))

    }

    @Test
    fun bindPasswordTest() {
        onView(withId(R.id.et_password)).perform(replaceText(PASSWORD))
        assertThat(viewModel.password.get(), `is`(PASSWORD))
    }

    @Test
    fun bindUsernameTest() {
        onView(withId(R.id.et_username)).perform(replaceText(USERNAME))
        assertThat(viewModel.username.get(), `is`(USERNAME))
    }

    @Test
    fun signInButtonEnabledBindTest() {
        onView(withId(R.id.et_email)).perform(click(), typeText(EMAIL))
        onView(withId(R.id.et_password)).perform(click(), typeText(PASSWORD))
        onView(withId(R.id.et_username)).perform(click(), typeText(USERNAME))
        onView(withId(R.id.tv_signin)).check(matches(isEnabled()))
    }

    @Test
    fun clickSignInButtonTest() {
        onView(withId(R.id.et_email)).perform(click(), typeText(EMAIL))
        onView(withId(R.id.et_password)).perform(click(), typeText(PASSWORD))
        onView(withId(R.id.et_username)).perform(click(), typeText(USERNAME))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.tv_signin)).perform(click())
        verify(authApiClient).register(USERNAME, EMAIL, PASSWORD)
    }

    @Test
    fun clickGoogleSignInTest() {
        onView(withId(R.id.tv_connect_with_google)).perform(click())
        verify(authApiClient).signInWithGoogle()
    }

    companion object {
        private const val USERNAME = "Username"
        private const val EMAIL = "Email"
        private const val PASSWORD = "Password"
    }

}
