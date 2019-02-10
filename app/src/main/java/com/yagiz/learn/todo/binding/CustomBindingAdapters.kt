package com.yagiz.learn.todo.binding

import android.arch.lifecycle.MutableLiveData
import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.yagiz.learn.todo.adapter.ItemListScreenAdapter
import com.yagiz.learn.todo.model.TaskItem
import com.yagiz.learn.todo.navigator.ITaskNavigator

@BindingAdapter(value = ["data", "navigator"], requireAll = true)
fun RecyclerView.setRecyclerView(data: MutableLiveData<List<TaskItem>>, navigator: ITaskNavigator) {
    Log.d("setRecyclerView", "Data: ${data.value}")
    if (layoutManager == null) layoutManager = LinearLayoutManager(this.context)
    if (adapter == null) adapter = ItemListScreenAdapter(navigator)
    (adapter as ItemListScreenAdapter).updateDataset(data.value ?: listOf())
}

@BindingAdapter("visibleIf")
fun setVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("imageUrl")
fun setImageUrl(view: ImageView, imageUrl: String) {
}
