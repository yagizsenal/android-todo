package com.yagiz.learn.todo.livedata

class MutableStatefulLiveData<T>(state: DataState,data: T) : StatefulLiveData<T>(state, data) {

    public override fun setValue(state: DataState, data: T) {
        super.setValue(state, data)
    }

    public override fun postData(data: T) {
        super.postData(data)
    }

    public override fun postValue(state: DataState, data: T) {
        super.postValue(state, data)
    }

    public override fun postState(state: DataState) {
        super.postState(state)
    }


}