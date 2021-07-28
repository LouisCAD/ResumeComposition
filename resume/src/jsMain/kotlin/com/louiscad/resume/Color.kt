package com.louiscad.resume

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgba

actual fun Color(color: Long): Color {
    return Color(value = color.toULong())
}

actual value class Color(val value: ULong) {
    fun asWebColor(): CSSColorValue = with(value.toInt()) {
        return rgba(
            r = (this shr 16) and 0xff,
            g = (this shr 8) and 0xff,
            b = this and 0xff,
            a = (this shr 24) and 0xff,
        )
    }
}
