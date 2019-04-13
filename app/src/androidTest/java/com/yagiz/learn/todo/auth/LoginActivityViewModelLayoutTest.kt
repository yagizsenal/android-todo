package com.yagiz.learn.todo.auth

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import com.yagiz.learn.todo.BR
import com.yagiz.learn.todo.BaseLayoutTest
import com.yagiz.learn.todo.R
import com.yagiz.learn.todo.databinding.ActivityLoginBinding
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class LoginActivityViewModelLayoutTest : BaseLayoutTest<ActivityLoginBinding,LoginActivityViewModel>(){
    private lateinit var viewModel: LoginActivityViewModel
    private lateinit var navigator: IAuthNavigator

    @Before
    fun setup(){
        navigator = mock(IAuthNavigator::class.java)
        viewModel = LoginActivityViewModel(navigator)

    }

    @Test
    fun nullViewModelTest(){
        setLayout(R.layout.activity_login, BR.viewModel,null)

        onView(withId(R.id.et_email)).check(matches(withText("")))
        onView(withId(R.id.et_password)).check(matches(withText("")))
        onView(withId(R.id.btn_signin)).check(matches(not(isEnabled())))
    }

    @Test
    fun bindEmailTest(){
        setLayout(R.layout.activity_login,BR.viewModel,viewModel)
        viewModel.email.set(EMAIL)
        onView(withId(R.id.et_email)).check(matches(withText(EMAIL)))
    }

    @Test
    fun bindPasswordTest(){
        setLayout(R.layout.activity_login,BR.viewModel,viewModel)
        viewModel.password.set(PASSWORD)
        onView(withId(R.id.et_password)).check(matches(withText(PASSWORD)))
    }

    @Test
    fun bindLoginButtonEnabledTest(){
        setLayout(R.layout.activity_login,BR.viewModel,viewModel)
        viewModel.password.set(PASSWORD)
        viewModel.email.set(EMAIL)
        onView(withId(R.id.btn_signin)).perform(click())
        verify(navigator).signInWithEmailAndPass(EMAIL, PASSWORD)
    }

    companion object {
        private const val EMAIL = "email"
        private const val PASSWORD = "password"
    }
}
