package com.example.wellnessapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wellnessapp.ui.theme.WellnessAppTheme


@Composable
fun StateFulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(value = 0) }

    StatelessCounter(
        count,
        onIncrement = {
            count++
        },
        modifier
    )
}

@Composable
private fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(
                text = "You've had $count cups of water"
            )
        }
        Button(
            enabled = count < 10,
            onClick = onIncrement,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Add one")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    WellnessAppTheme {
        StateFulCounter()
    }
}