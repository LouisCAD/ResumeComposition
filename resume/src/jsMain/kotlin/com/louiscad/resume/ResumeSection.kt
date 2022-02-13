package com.louiscad.resume

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import com.louiscad.resume.data.ResumeDataItem
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.H5
import org.jetbrains.compose.web.dom.H6
import org.jetbrains.compose.web.dom.Text

@Composable
fun ResumeSection(
    title: String,
    styleSheet: ResumeStyleSheet = resumeStyleSheet,
    useKotlinColors: Boolean = false,
    content: @Composable () -> Unit
) {
    val sectionDepth = CurrentDepth.current
    Div({
        if (sectionDepth == 2u) {
            classes(styleSheet.borderedSectionWrapper)
            if (useKotlinColors) classes("kotlin-colors-conic-gradient")
        }
    }) {
        Div({
            if (sectionDepth == 2u) classes(styleSheet.borderedSection)
        }) {
            when (sectionDepth) {
                1u -> H2 { Text(title) }
                2u -> H3 { Text(title) }
                3u -> H4 { Text(title) }
                4u -> H5 { Text(title) }
                else -> H6 { Text(title) }
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
    title: String,
    items: List<ResumeDataItem>
) = ResumeSection(title = title) {
    items.forEach { item -> Div { ResumeItem(item) } }
}

private val CurrentDepth = compositionLocalOf { 1u }
