package com.louiscad.resume.extensions

import org.jetbrains.compose.web.css.CSSBuilder
import org.jetbrains.compose.web.css.CSSUnitValue
import org.jetbrains.compose.web.css.StyleBuilder

/**
 * This overload allows setting padding for all sides.
 * It exists because the Compose for Web one leads to an overload
 * resolution ambiguity because of the vararg parameter.
 */
fun CSSBuilder.padding(all: CSSUnitValue) {
    property("padding", all)
}

fun CSSBuilder.padding(
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
