package com.louiscad.resume.extensions

import org.jetbrains.compose.common.internal.castOrCreate
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.common.ui.unit.Dp
import org.jetbrains.compose.common.ui.unit.dp
import org.jetbrains.compose.web.css.CSSUnitValue
import org.jetbrains.compose.web.css.StyleBuilder
import org.jetbrains.compose.web.css.px

fun Modifier.padding(horizontal: Dp = 0.dp, vertical: Dp = 0.dp): Modifier = castOrCreate().apply {
    // yes, it's not a typo, what Modifier.padding does is actually adding margin
    add {
        if (horizontal != 0.dp) {
            val pxValue = horizontal.value.px
            property("margin-left", pxValue)
            property("margin-right", pxValue)
        }
        if (vertical != 0.dp) {
            val pxValue = vertical.value.px
            property("margin-top", pxValue)
            property("margin-bottom", pxValue)
        }
    }
}

/**
 * This overload allows setting padding for all sides.
 * It exists because the Compose for Web one leads to an overload
 * resolution ambiguity because of the vararg parameter.
 */
fun StyleBuilder.padding(all: CSSUnitValue) {
    property("padding", all)
}

fun StyleBuilder.padding(
    horizontal: CSSUnitValue? = null,
    vertical: CSSUnitValue? = null
) {
    // padding hasn't Typed OM yet
    horizontal?.let {
        property("padding-left", it)
        property("padding-right", it)
    }
    vertical?.let {
        property("padding-top", it)
        property("padding-bottom", it)
    }
}

fun StyleBuilder.padding(
    left: CSSUnitValue? = null,
    top: CSSUnitValue? = null,
    right: CSSUnitValue? = null,
    bottom: CSSUnitValue? = null
) {
    // padding hasn't Typed OM yet
    left?.let { property("padding-left", it) }
    top?.let { property("padding-top", it) }
    right?.let { property("padding-right", it) }
    bottom?.let { property("padding-bottom", it) }
}
