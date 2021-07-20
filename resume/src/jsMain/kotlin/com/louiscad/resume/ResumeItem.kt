package com.louiscad.resume

import androidx.compose.runtime.Composable
import com.louiscad.resume.data.ResumeDataItem
import org.jetbrains.compose.common.material.Text
import org.jetbrains.compose.web.dom.P

@Composable
actual fun ResumeItem(data: ResumeDataItem) {
    when (data) {
        is ResumeDataItem.Text -> P { LinkableText(data.text) }
    }
}
