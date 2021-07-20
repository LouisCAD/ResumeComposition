package com.louiscad.resume

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDecoration.Companion
import androidx.compose.ui.unit.dp
import com.louiscad.resume.data.ResumeDataItem

@Composable
fun ResumeSection(
    title: String,
    borderColor: Color? = null,
    content: @Composable () -> Unit
) {
    val sectionDepth = LocalSectionDepth.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .let {
                if (sectionDepth == 1) it else it.border(
                    width = 2.dp,
                    color = borderColor ?: when {
                        sectionDepth % 2 == 0 -> Color(0xFFC812DF)
                        else -> Color(0xFF_00BBFF)
                    },
                    /* // Gradient causes very poor rendering performance in the PDF apps that don't crash.
                    brush = Brush.sweepGradient(
                      colors = when {
                        sectionDepth % 2 == 0 -> listOf(Color.Magenta, Color.Cyan, Color.Magenta)
                        else -> listOf(Color.Cyan, Color.Magenta, Color.Cyan)
                      }
                    ),
                    */
                    shape = RoundedCornerShape(8.dp)
                ).padding(8.dp)
            }
    ) {
        Text(
            text = title,
            modifier = Modifier.align(CenterHorizontally),
            textAlign = TextAlign.Center,
            /*color = when (sectionDepth) {
              2 -> ResumeData.Colors.someDarkColor
              else -> Color.Unspecified
            },*/
            style = with(MaterialTheme.typography) {
                when (sectionDepth + 2) {
                    1 -> h3
                    2 -> h4
                    3 -> h5
                    4 -> h6
                    5 -> subtitle1
                    else -> subtitle2
                }
            }
        )
        val newDepth = sectionDepth + 1
        CompositionLocalProvider(LocalSectionDepth provides newDepth) {
            content()
        }
    }
}

@Composable
fun ResumeSection(
    title: String,
    items: List<ResumeDataItem>
) = ResumeSection(title = title) {
    items.forEach { item -> ResumeItem(item) }
}

private val LocalSectionDepth = compositionLocalOf { 1 }
