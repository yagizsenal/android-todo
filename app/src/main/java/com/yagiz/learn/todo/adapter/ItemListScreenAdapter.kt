package com.yagiz.learn.todo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yagiz.learn.todo.databinding.ItemTaskBinding
import com.yagiz.learn.todo.model.TaskItem
import com.yagiz.learn.todo.view.ITaskNavigator
import com.yagiz.learn.todo.view.TaskItemViewModel

class ItemListScreenAdapter(private val navigator: ITaskNavigator) : RecyclerView.Adapter<ItemListScreenAdapter.TodoItemViewHolder>() {
    private var dataset: List<TaskItem> = listOf()

    override fun onBindViewHolder(viewHolder: TodoItemViewHolder, position: Int) {
        with(viewHolder.binding) {
            if (viewModel == null) viewModel = TaskItemViewModel(navigator)
            viewModel?.setModel(dataset[position])
            executePendingBindings()
        }
    }

    fun updateDataset(dataset: List<TaskItem>) {
        this.dataset = dataset
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = dataset.size

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): TodoItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTaskBinding.inflate(inflater, parent, false)
        return TodoItemViewHolder(binding)
    }

    class TodoItemViewHolder(val binding: ItemTaskBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: TaskItemViewModel) {

            with(binding) {
                this.viewModel = viewModel
                executePendingBindings()
            }
        }

    }

}
