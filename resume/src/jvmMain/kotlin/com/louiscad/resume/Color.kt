package com.louiscad.resume

import androidx.compose.ui.graphics.Color as ComposeUiColor

actual fun Color(color: Long): Color = ComposeUiColor(color)

actual typealias Color = ComposeUiColor
