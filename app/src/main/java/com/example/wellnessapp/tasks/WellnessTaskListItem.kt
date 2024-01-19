package com.example.wellnessapp.tasks

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wellnessapp.model.WellnessTask

@Composable
fun WellnessTaskItem(
    task: WellnessTask,
    onCheckBoxChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    WellnessTaskItem(
        taskName = task.label,
        checkedState = task.checked.value,
        onCheckBoxChange = onCheckBoxChange,
        onClose = onClose,
        modifier = modifier,
        )
}

@Composable
private fun WellnessTaskItem(
    taskName: String,
    checkedState: Boolean,
    onCheckBoxChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier,
    ) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(start = 16.dp)
    ) {
        Text(text = taskName)
        Spacer(modifier = Modifier.weight(1f))
        Row() {
            Checkbox(
                checked = checkedState,
                onCheckedChange = onCheckBoxChange
            )
            IconButton(onClick = onClose) {
                Icon(imageVector = Icons.Default.Clear, contentDescription = null)
            }
        }
    }
}