package com.yagiz.learn.todo.binding

import android.arch.lifecycle.LiveData
import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.yagiz.learn.todo.tasks.ITaskNavigator
import com.yagiz.learn.todo.tasks.ItemListScreenAdapter
import com.yagiz.learn.todo.tasks.TaskItem

@BindingAdapter(value = ["data", "navigator"], requireAll = true)
fun RecyclerView.setRecyclerView(data: LiveData<ArrayList<TaskItem>>?, navigator: ITaskNavigator?) {
    if (layoutManager == null) layoutManager = LinearLayoutManager(this.context)
    if (data == null || navigator == null) return
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

@BindingAdapter("onClick")
fun TextView.setOnClickTextView(listener: View.OnClickListener) {
    this.setOnClickListener(listener)
    this.isClickable = true
}
