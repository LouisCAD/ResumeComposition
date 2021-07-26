package com.louiscad.resume

import com.louiscad.resume.extensions.margin
import com.louiscad.resume.extensions.padding
import com.louiscad.resume.extensions.unaryMinus
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.background
import org.jetbrains.compose.web.css.backgroundClip
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.bottom
import org.jetbrains.compose.web.css.boxSizing
import org.jetbrains.compose.web.css.left
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.right
import org.jetbrains.compose.web.css.top

object LouisCadResumeStyleSheet : ResumeStyleSheet() {

    override val borderedSection: String by style {
        val borderSize = 2.px
        "$self:before" {
            background("conic-gradient(from 150deg, magenta, cyan, magenta)")
            margin(-borderSize)
            property("border-radius", "inherit")
            property("z-index", -1)
            position(Position.Absolute)
            top(0.px); bottom(0.px); left(0.px); right(0.px)
            property("content", "''")
        }
        background("white")
        border(width = borderSize, style = LineStyle.Solid, color = Color("transparent"))
        borderRadius(10.px)
        position(Position.Relative)
        backgroundClip("padding-box")
        boxSizing("border-box")

        property("margin-block", 10.px)
        margin(horizontal = 5.px, vertical = 10.px)
        padding(horizontal = 10.px)
        padding(bottom = 10.px)
    }
}
