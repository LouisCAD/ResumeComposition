package com.louiscad.resume

import org.jetbrains.compose.web.css.Color.RGBA as ComposeWebColor


actual fun Color(color: Long): Color {
    return Color(value = color.toULong())
}

actual value class Color(val value: ULong) {
    fun asWebColor(): ComposeWebColor = with(value.toInt()) {
        return ComposeWebColor(
            r = (this shr 16) and 0xff,
            g = (this shr 8) and 0xff,
            b = this and 0xff,
            a = (this shr 24) and 0xff,
        )
    }
}
