package com.yagiz.learn.todo.livedata

data class StatefulData<T>(var state: DataState, var data: T)