package com.louiscad.resume

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.louiscad.resume.data.ResumeDataItem

@OptIn(ExperimentalUnitApi::class)
@Composable
actual fun ResumeItem(data: ResumeDataItem) {
   when (data) {
      is ResumeDataItem.Text -> Text(
         text = data.text,
         modifier = Modifier.padding(vertical = 1.dp),
         letterSpacing = TextUnit(value = .2f, type = TextUnitType.Sp)
      )
      is ResumeDataItem.Line -> Row {
         data.icon?.let {
            Icon(imageVector = it, contentDescription = null)
         }
         Text(
            text = data.text,
            modifier = Modifier.padding(vertical = 1.dp),
            letterSpacing = TextUnit(value = .2f, type = TextUnitType.Sp)
         )
      }
   }
}
