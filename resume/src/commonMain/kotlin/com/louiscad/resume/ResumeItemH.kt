package com.louiscad.resume

import androidx.compose.runtime.Composable
import com.louiscad.resume.data.ResumeDataItem

@Composable
expect fun ResumeItem(data: ResumeDataItem)
