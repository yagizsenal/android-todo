package com.yagiz.learn.todo.auth

import dagger.Module
import dagger.Provides

@Module
class AuthApiClientModule {

    @Provides
    fun authApiClient(client: AuthApiClient): AuthApiClient {
        return client
    }

    @Provides
    fun user(client: AuthApiClient): User?{
        return client.user
    }
}