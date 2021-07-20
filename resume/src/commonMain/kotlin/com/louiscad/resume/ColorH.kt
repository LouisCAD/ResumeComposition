package com.louiscad.resume

import kotlin.jvm.JvmInline

expect fun Color(color: Long): Color

@JvmInline
expect value class Color(val value: ULong)
