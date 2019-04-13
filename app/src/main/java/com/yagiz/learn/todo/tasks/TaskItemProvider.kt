package com.yagiz.learn.todo.tasks

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.yagiz.learn.todo.tasks.TaskItem

class TaskItemProvider {
    private val TAG = "TaskItemProvider"

    fun getTasks(): MutableLiveData<List<TaskItem>> {
        val user = FirebaseAuth.getInstance().currentUser
        val db = FirebaseFirestore.getInstance()
        val results = MutableLiveData<List<TaskItem>>()
        db.collection("users").document(user!!.uid)
                .get()
                .addOnSuccessListener { result ->
                    val data = mutableListOf<TaskItem>()
                    Log.d(TAG,result.toString())
                    val tasks = result.data!!["tasks"] as ArrayList<*>
                    for (i in 0..(tasks.size - 1)) {
                        val task = tasks[i] as HashMap<String, Any>
                        data.add(TaskItem(task["title"] as String, task["subtitle"] as String, task["completed"] as Boolean))
                        Log.d(TAG, "Data: $data")
                    }
                    results.postValue(data)
                }
        return results
    }
}
