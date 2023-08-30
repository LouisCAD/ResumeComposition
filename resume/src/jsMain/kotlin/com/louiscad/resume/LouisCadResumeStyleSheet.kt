package com.louiscad.resume

import com.louiscad.resume.extensions.margin
import com.louiscad.resume.extensions.padding
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.Color

object LouisCadResumeStyleSheet : ResumeStyleSheet() {

    init {
        "@page" {
            property("size", "A4 landscape")
            margin(0.mm)
        }
        ".text-icon" {
            property("vertical-align", "middle")
            marginTop(-2.px)
            height(12.px)
            marginRight(4.px)
        }
        ".h2-icon" {
            property("vertical-align", "middle")
            marginTop(-4.px)
            height(20.px)
            marginRight(8.px)
        }
        ".h3-icon" {
            marginTop(-3.px)
            property("vertical-align", "middle")
            height(18.px)
            marginRight(6.px)
        }
        ".h4-icon" {
            marginTop(-2.px)
            property("vertical-align", "middle")
            height(14.px)
            marginRight(4.px)
        }
        ".h5-icon" {
            marginTop(-2.px)
            property("vertical-align", "middle")
            height(12.px)
            marginRight(4.px)
        }
        ".h6-icon" {
            marginTop(-2.px)
            property("vertical-align", "middle")
            height(12.px)
            marginRight(4.px)
        }
    }

    private val borderSize = 2.px
    private val borderRadius = 10.px

    override val root by style {
        minWidth(1049.px)
    }

    override val borderedSectionWrapper: String by style {
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
