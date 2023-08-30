package com.louiscad.resume

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import com.louiscad.resume.data.ResumeDataItem
import org.jetbrains.compose.common.foundation.layout.Box
import org.jetbrains.compose.common.material.Text
import org.jetbrains.compose.web.css.background
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLHeadingElement

@Composable
fun ResumeSection(
    title: Title,
    styleSheet: ResumeStyleSheet = resumeStyleSheet,
    borderGradient: SweepGradient = SweepGradient.default,
    content: @Composable () -> Unit
) {
    val sectionDepth = CurrentDepth.current
    Div({
        if (sectionDepth == 2u) {
            classes(styleSheet.borderedSectionWrapper)
            style {
//                background("black")
                background(borderGradient.backgroundCssValue.also { println(it) })
            }
//            if (useKotlinColors) classes("kotlin-colors-conic-gradient")
        }
    }) {
        Div({
            if (sectionDepth == 2u) classes(styleSheet.borderedSection)
        }) {
            val headingContent: ContentBuilder<HTMLHeadingElement> = {
                title.icon?.let {
                    Img(src = "svg/${it.name}.svg") {
                        val headingNumber = (sectionDepth + 1u).coerceAtMost(6u)
                        classes("h$headingNumber-icon")
                    }
                }
                Text(title.text)
            }
            when (sectionDepth) {
                1u -> H2(content = headingContent)
                2u -> H3(content = headingContent)
                3u -> H4(content = headingContent)
                4u -> H5(content = headingContent)
                else -> H6(content = headingContent)
            }
            val newDepth = sectionDepth + 1u
            CompositionLocalProvider(CurrentDepth provides newDepth) {
                content()
            }
        }
    }
}

@Composable
fun ResumeSection(
    title: Title,
    items: List<ResumeDataItem>
) = ResumeSection(title = title) {
    items.forEach { item -> Box { ResumeItem(item) } }
}

private val CurrentDepth = compositionLocalOf { 1u }
