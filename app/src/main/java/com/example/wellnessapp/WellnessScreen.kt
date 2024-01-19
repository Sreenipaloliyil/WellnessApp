package com.example.wellnessapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wellnessapp.tasks.WellnessTaskList
import com.example.wellnessapp.ui.theme.WellnessAppTheme
import com.example.wellnessapp.viewModel.WellnessViewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column {
        StateFulCounter(modifier)
        WellnessTaskList(
            tasks = wellnessViewModel.tasks,
            onTaskCheckedStateChange = { task, isChecked ->
                wellnessViewModel.update(task,isChecked)
            },
            onCloseTask = {
                wellnessViewModel.remove(it)
            },
            modifier = modifier
        )
    }
}



@Preview(showBackground = true, widthDp = 400)
@Composable
fun WellnessTaskItemPreview() {
    WellnessAppTheme {
        WellnessScreen()
    }
}

//@Preview(name = "small font", group = "Font scales", fontScale = 0.5f, showBackground = true, widthDp = 400)
//@Preview(name = "large font", group = "Font scales", fontScale = 1.5f, showBackground = true, widthDp = 400)
//annotation class FontScalePreviews