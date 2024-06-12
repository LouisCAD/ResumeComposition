package com.louiscad.resume

import com.louiscad.resume.extensions.margin
import org.jetbrains.compose.web.css.*

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

        "@page" {
            property("size", paperSize)
            margin(0.mm)
        }
    }

    open val paperSize get() = "auto"

    open val trunk by style {
        fontFamily("Roboto", "sans-serif")
        fontWeight(400)
        property("white-space", "pre-line")
        "a, a:visited" {
            color(rgb(0x00, 0xb5, 0xe5))
        }
        property("padding", "0.4in")
        paddingBottom(0.px)
        media("print") {
            margin((-10).px)
        }
        "html" {
            margin(0.mm)
        }

        // Keep background graphics, and keep colors intact.
        property("color-adjust", "exact")
        property("-webkit-print-color-adjust", "exact")
    }
    open val sectionsColumn by style {
        "h1, h2, h3, h4, h5, h6".split(", ").map {
            desc(self, selector(it))
        }.let { group(*it.toTypedArray()) } style {
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

    open val borderedSectionWrapper: String by style {}

    open val borderedSection by style {}
}
