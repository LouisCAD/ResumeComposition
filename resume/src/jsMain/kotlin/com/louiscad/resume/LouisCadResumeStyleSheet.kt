package com.louiscad.resume

import com.louiscad.resume.extensions.margin
import com.louiscad.resume.extensions.padding
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.background
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.minWidth
import org.jetbrains.compose.web.css.minus
import org.jetbrains.compose.web.css.mm
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.times

object LouisCadResumeStyleSheet : ResumeStyleSheet() {

    init {
        "@page" {
            property("size", "A4 landscape")
            margin(0.mm)
        }
    }

    private val borderSize = 2.px
    private val borderRadius = 10.px

    override val root by style {
        minWidth(1049.px)
    }

    override val borderedSectionWrapper: String by style {
        background("conic-gradient(from 150deg, magenta, cyan, magenta)")
        "$self.kotlin-colors-conic-gradient" {
            background("conic-gradient(from 225deg, #7F52FF, #C711E1, #E44857, #C711E1, #7F52FF)")
        }
        padding(borderSize)
        borderRadius(borderRadius)

        margin(horizontal = 5.px, vertical = 10.px)
        property("margin-block", 10.px)
    }

    override val borderedSection: String by style {
        background("white")
        border(width = borderSize, style = LineStyle.Solid, color = Color("transparent"))
        borderRadius(borderRadius - borderSize)

        padding(horizontal = 10.px - borderSize)
        padding(bottom = 10.px - (borderSize * 2))
    }
}
