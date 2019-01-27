package com.yagiz.learn.todo.binding

import android.databinding.BindingAdapter
import android.net.Uri
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.yagiz.learn.todo.adapter.ItemListScreenAdapter
import com.yagiz.learn.todo.model.TodoItem
import com.yagiz.learn.todo.view.ItemListScreenViewModel

@BindingAdapter("data")
fun RecyclerView.setRecyclerView(data: List<TodoItem>){
    if (this.layoutManager == null) this.layoutManager = LinearLayoutManager(this.context)
    if (this.adapter == null){
        val adapter = ItemListScreenAdapter()
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
fun setImageUrl(view: ImageView,imageUrl: String){
}
