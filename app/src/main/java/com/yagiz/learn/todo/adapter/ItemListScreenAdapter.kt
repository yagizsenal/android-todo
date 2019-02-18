package com.yagiz.learn.todo.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yagiz.learn.todo.MainActivity
import com.yagiz.learn.todo.databinding.ItemTaskBinding
import com.yagiz.learn.todo.model.TaskItem
import com.yagiz.learn.todo.navigator.ITaskNavigator
import com.yagiz.learn.todo.view.TaskItemViewModel

class ItemListScreenAdapter(private val navigator: ITaskNavigator) : RecyclerView.Adapter<ItemListScreenAdapter.TaskItemViewHolder>() {
    private val TAG = "ItemListScreenAdapter"
    private var dataset: List<TaskItem> = listOf()

    override fun onBindViewHolder(viewHolder: TaskItemViewHolder, position: Int) {
        with(viewHolder.binding) {
            this.viewModel?.setModel(dataset[position])
            executePendingBindings()
        }
    }

    fun updateDataset(dataset: List<TaskItem>) {
        Log.d(TAG,"Updating dataset")
        this.dataset = dataset
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = dataset.size

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): TaskItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTaskBinding.inflate(inflater, parent, false).apply {
            viewModel = TaskItemViewModel(navigator)
            setLifecycleOwner(parent.context as MainActivity)
        }
        return TaskItemViewHolder(binding)
    }

    class TaskItemViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root)
}
