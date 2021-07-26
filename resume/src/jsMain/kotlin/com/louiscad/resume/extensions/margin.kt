package com.louiscad.resume.extensions

import org.jetbrains.compose.web.css.CSSUnitValue
import org.jetbrains.compose.web.css.StyleBuilder

/**
 * This overload allows setting margin for all sides.
 * It exists because the Compose for Web one leads to an overload
 * resolution ambiguity because of the vararg parameter.
 */
fun StyleBuilder.margin(all: CSSUnitValue) {
    property("margin", all)
}

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
