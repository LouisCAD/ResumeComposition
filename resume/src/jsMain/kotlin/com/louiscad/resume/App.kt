package com.louiscad.resume

import androidx.compose.runtime.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

@Composable
actual fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    Button({ onClick { text = "Hello, Compose!" } }) {
        Text(text)
    }
}
