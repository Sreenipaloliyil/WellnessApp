package com.example.wellnessapp.viewModel

import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.wellnessapp.model.WellnessTask

class WellnessViewModel: ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    private fun getWellnessTasks() = List(30) {
        WellnessTask(it, label = "Task $it")
    }

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }
    fun update(task: WellnessTask, isChecked: Boolean) {
        _tasks.find { it.id == task.id }?.let {
            it.checked.value = isChecked
        }
    }
}