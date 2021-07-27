package com.louiscad.resume

import com.louiscad.resume.extensions.margin
import com.louiscad.resume.extensions.padding
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontFamily
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.media
import org.jetbrains.compose.web.css.paddingBottom
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.selectors.descendant
import org.jetbrains.compose.web.css.selectors.selector
import org.jetbrains.compose.web.css.textAlign

abstract class ResumeStyleSheet : StyleSheet() {
    init {
        "p" {
            fontSize(11.px)
            property("margin-block", 0)
        }
        "h1, h2, h3, h4, h5, h6" {
            property("margin-block", 0)
            fontWeight(400)
        }
        "h1" {
            fontSize(20.px)
            fontFamily("Overpass", "sans-serif")
        }
        "h2" {
            fontSize(18.px)
            fontFamily("Overpass", "sans-serif")
        }
        "h3" { fontSize(16.px) }
        "h4" { fontSize(14.px) }
        "h5" { fontSize(13.px) }
    }

    open val root by style {
        fontFamily("Roboto", "sans-serif")
        fontWeight(400)
        property("white-space", "pre-line")
        "a, a:visited" {
            color(Color.RGB(0x00, 0xb5, 0xe5))
        }
        property("padding", "0.4in")
        paddingBottom(0.px)
        media("print") {
            margin((-10).px)
        }

        // Keep background graphics, and keep colors intact.
        property("color-adjust", "exact")
        property("-webkit-print-color-adjust", "exact")
    }
    open val sectionsColumn by style {
        "h1, h2, h3, h4, h5, h6".split(", ").map {
            descendant(self, selector(it))
        }.joinToString() style {
            textAlign("center")
            property("margin-block-start", 8.px)
            property("margin-block-end", 8.px)
        }
    }

    /**
     * Meant for columns (div elements) containing text above or below a [sectionsColumn].
     */
    open val nonSectionColumn by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        margin(10.px)
    }

    open val borderedSection: String by style {
        property("margin-block", 10.px)
        val borderSize = 2.px
        margin(horizontal = 5.px, vertical = 10.px)
        border(width = borderSize, style = LineStyle.Solid, color = Color("#00bbff"))
        borderRadius(10.px)
        padding(horizontal = 10.px)
        padding(bottom = 10.px)
    }
}
