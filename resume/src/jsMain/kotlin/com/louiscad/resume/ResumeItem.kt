package com.louiscad.resume

import androidx.compose.runtime.Composable
import com.louiscad.resume.data.ResumeDataItem
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P

@Composable
actual fun ResumeItem(data: ResumeDataItem) {
    when (data) {
        is ResumeDataItem.Text -> P { LinkableText(data.text) }
        is ResumeDataItem.Line -> P {
            data.icon?.name?.let {
                Img(src = "svg/$it.svg") {
                    classes("text-icon")
                }
            }
            LinkableText(data.text)
        }
    }
}
