package com.louiscad.resume.extensions

import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.times

operator fun <T : CSSUnit> CSSSizeValue<T>.unaryMinus(): CSSSizeValue<T> = this * -1
