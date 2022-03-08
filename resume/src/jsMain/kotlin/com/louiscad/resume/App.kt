package com.louiscad.resume

import androidx.compose.runtime.*
import org.jetbrains.compose.common.material.Button
import org.jetbrains.compose.common.material.Text

@Composable
actual fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    Button(onClick = {
        text = "Hello, Compose!"
    }) {
        Text(text)
    }
}
