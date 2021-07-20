package com.louiscad.resume.extensions

import org.jetbrains.compose.common.internal.castOrCreate
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.common.ui.unit.Dp
import org.jetbrains.compose.common.ui.unit.dp
import org.jetbrains.compose.web.css.CSSUnitValue
import org.jetbrains.compose.web.css.StyleBuilder
import org.jetbrains.compose.web.css.px

fun StyleBuilder.margin(
    horizontal: CSSUnitValue? = null,
    vertical: CSSUnitValue? = null
) {
    // margin hasn't Typed OM yet
    horizontal?.let {
        property("margin-left", it)
        property("margin-right", it)
    }
    vertical?.let {
        property("margin-top", it)
        property("margin-bottom", it)
    }
}

fun StyleBuilder.margin(
    left: CSSUnitValue? = null,
    top: CSSUnitValue? = null,
    right: CSSUnitValue? = null,
    bottom: CSSUnitValue? = null
) {
    // margin hasn't Typed OM yet
    left?.let { property("margin-left", it) }
    top?.let { property("margin-top", it) }
    right?.let { property("margin-right", it) }
    bottom?.let { property("margin-bottom", it) }
}
