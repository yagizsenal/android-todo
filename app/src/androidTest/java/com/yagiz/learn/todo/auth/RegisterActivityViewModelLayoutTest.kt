package com.yagiz.learn.todo.auth

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import com.yagiz.learn.todo.BR
import com.yagiz.learn.todo.BaseLayoutTest
import com.yagiz.learn.todo.R
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
    private lateinit var navigator: IAuthNavigator

    @Before
    fun setup() {
        navigator = mock(IAuthNavigator::class.java)
        viewModel = RegisterActivityViewModel(navigator)
    }

    @Test
    fun nullViewModelTest() {
        setLayout(R.layout.activity_register, BR.viewModel, null)

        onView(withId(R.id.et_email)).check(matches(withText("")))
        onView(withId(R.id.et_password)).check(matches(withText("")))
        onView(withId(R.id.btn_signin)).check(matches(not(isEnabled())))
    }

    @Test
    fun bindEmailTest() {
        setLayout(R.layout.activity_register, BR.viewModel, viewModel)
        onView(withId(R.id.et_email)).perform(replaceText("Email"))

        assertThat(viewModel.email.get(), `is`("Email"))

    }

    @Test
    fun bindPasswordTest() {
        setLayout(R.layout.activity_register, BR.viewModel, viewModel)
        onView(withId(R.id.et_password)).perform(replaceText("Password"))

        assertThat(viewModel.password.get(), `is`("Password"))
    }

    @Test
    fun signInButtonEnabledBindTest() {
        setLayout(R.layout.activity_register, BR.viewModel, viewModel)
        onView(withId(R.id.et_email)).perform(click(), typeText("Email"))
        onView(withId(R.id.et_password)).perform(click(), typeText("Password"))
        onView(withId(R.id.btn_signin)).check(matches(isEnabled()))
    }

    @Test
    fun clickSignInButtonTest() {
        setLayout(R.layout.activity_register, BR.viewModel, viewModel)
        onView(withId(R.id.et_email)).perform(click(), typeText("Email"))
        onView(withId(R.id.et_password)).perform(click(), typeText("Password"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btn_signin)).perform(click())
        verify(navigator).signInWithEmailAndPass("Email", "Password")
    }

}
