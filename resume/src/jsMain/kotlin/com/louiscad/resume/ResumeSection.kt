package com.louiscad.resume

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import com.louiscad.resume.data.ResumeDataItem
import com.louiscad.resume.extensions.margin
import com.louiscad.resume.extensions.padding
import org.jetbrains.compose.common.foundation.layout.Box
import org.jetbrains.compose.common.foundation.layout.Column
import org.jetbrains.compose.common.material.Text
import org.jetbrains.compose.web.css.Color.RGB
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.H5
import org.jetbrains.compose.web.dom.H6

@Composable
fun ResumeSection(
    title: String,
    content: @Composable () -> Unit
) {
    val sectionDepth = CurrentDepth.current.depth
    Div({
        style {
            if (sectionDepth == 2u) {
                property("margin-block", 10.px)
                margin(horizontal = 5.px,vertical = 10.px)
                border(width = 2.px, style = LineStyle.Solid, color = RGB(0x33, 0xb5, 0xe5))
                borderRadius(10.px)
                padding(horizontal = 10.px)
                padding(bottom = 10.px)
            }
        }
    }) {
        Column {
            when (sectionDepth) {
                1u -> H2 { Text(title) }
                2u -> H3 { Text(title) }
                3u -> H4 { Text(title) }
                4u -> H5 { Text(title) }
                else -> H6 { Text(title) }
            }
            val newDepth = ResumeSectionDepth(depth = sectionDepth + 1u)
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
    items.forEach { item -> Box { ResumeItem(item) } }
}

private val CurrentDepth = compositionLocalOf { ResumeSectionDepth(1u) }

private class ResumeSectionDepth(val depth: UInt)
