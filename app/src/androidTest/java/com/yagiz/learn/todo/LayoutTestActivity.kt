package com.yagiz.learn.todo

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity

class LayoutTestActivity<DB: ViewDataBinding, VM: ViewModel> : AppCompatActivity() {

    fun setLayoutBindings(layoutId: Int, variable: Int, value: VM?) {
        runOnUiThread {
            val binding = DataBindingUtil.setContentView<DB>(this, layoutId)
            binding.setVariable(variable, value)
            binding.executePendingBindings()
        }
    }

}