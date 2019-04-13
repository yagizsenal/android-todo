package com.yagiz.learn.todo

import android.arch.lifecycle.MutableLiveData

interface IProvider<T> {
    fun load() : MutableLiveData<Collection<T>>
}
