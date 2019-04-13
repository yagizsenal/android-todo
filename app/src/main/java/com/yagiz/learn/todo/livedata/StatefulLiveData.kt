package com.yagiz.learn.todo.livedata

import android.arch.lifecycle.LiveData

open class StatefulLiveData<T>(state: DataState, data: T) : LiveData<StatefulData<T>>() {

    init {
        value = StatefulData(state, data)
    }

    open var data: T
        get() = value!!.data
        protected set(newValue) {
            value!!.data = newValue
            triggerValueChanged()
        }

    open var state: DataState
        get() = value!!.state
        protected set(newState) {
            value!!.state = newState
            triggerValueChanged()
        }

    protected open fun setValue(state: DataState, data: T) {
        value!!.data = data
        value!!.state = state
        triggerValueChanged()
    }

    protected open fun postValue(state: DataState, data: T) {
        value!!.data = data
        value!!.state = state
        postValue(value)
    }

    protected open fun postState(state: DataState) {
        value!!.state = state
        postValue(value)
    }

    protected open fun postData(data: T) {
        value!!.data = data
        postValue(value)
    }

    private fun triggerValueChanged() {
        value = value
    }

}