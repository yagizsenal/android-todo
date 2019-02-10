package com.yagiz.learn.todo.binding

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.yagiz.learn.todo.adapter.ItemListScreenAdapter
import com.yagiz.learn.todo.model.TaskItem
import com.yagiz.learn.todo.navigator.ITaskNavigator

@BindingAdapter(value = ["data", "navigator"], requireAll = true)
fun RecyclerView.setRecyclerView(data: List<TaskItem>, navigator: ITaskNavigator) {
    if (this.layoutManager == null) this.layoutManager = LinearLayoutManager(this.context)
    if (this.adapter == null) {
        val adapter = ItemListScreenAdapter(navigator)
        this.adapter = adapter
        adapter.updateDataset(data)
        return
    }
    (this.adapter as ItemListScreenAdapter).updateDataset(data)
}

@BindingAdapter("visibleIf")
fun setVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("imageUrl")
fun setImageUrl(view: ImageView, imageUrl: String) {
}
