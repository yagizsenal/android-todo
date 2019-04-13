package com.yagiz.learn.todo.auth

import com.yagiz.learn.todo.api.AuthApiClient
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class AuthApiClientUnitTest {

    private lateinit var client: AuthApiClient;

    @Before
    fun setup() {
        client = AuthApiClient()
    }

    @Test
    fun notLoggedInTest() {
        assertNull(client.user)
    }

    @Test
    fun loginTest() {
        client.loginWithEmail("", "")
        assertNotNull(client.user)
    }

}