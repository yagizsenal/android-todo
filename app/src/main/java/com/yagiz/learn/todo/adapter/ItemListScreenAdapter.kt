package com.yagiz.learn.todo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yagiz.learn.todo.databinding.ItemTodoBinding
import com.yagiz.learn.todo.model.TodoItem
import com.yagiz.learn.todo.view.TodoItemViewModel

class ItemListScreenAdapter :
    RecyclerView.Adapter<ItemListScreenAdapter.TodoItemViewHolder>() {
    private var dataset: List<TodoItem> = listOf()

    override fun onBindViewHolder(viewHolder: TodoItemViewHolder, position: Int) {
        with (viewHolder.binding){
            if (viewModel == null) viewModel = TodoItemViewModel()
            viewModel?.setModel(dataset[position])
            executePendingBindings()
        }
    }

    fun updateDataset(dataset: List<TodoItem>) {
        this.dataset = dataset
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = dataset.size

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): TodoItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTodoBinding.inflate(inflater, parent, false)
        return TodoItemViewHolder(binding)
    }

    class TodoItemViewHolder(val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: TodoItemViewModel) {

            with(binding) {
                this.viewModel = viewModel
                executePendingBindings()
            }
        }

    }

}
