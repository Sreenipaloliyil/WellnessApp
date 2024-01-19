package com.example.wellnessapp.tasks

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.wellnessapp.model.WellnessTask

@Composable
fun WellnessTaskList(
    tasks: List<WellnessTask>,
    onTaskCheckedStateChange: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier
) {

    LazyColumn(modifier = modifier) {
        items(items = tasks, key = {item -> item.id }) { item ->
            WellnessTaskItem(
                task = item,
                onCheckBoxChange = { isChecked -> onTaskCheckedStateChange(item, isChecked) },
                onClose = { onCloseTask(item) }
            )
        }
    }
}