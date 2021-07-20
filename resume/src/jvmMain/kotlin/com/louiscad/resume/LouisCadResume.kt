package com.louiscad.resume

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.louiscad.resume.data.ResumeDataItem
import com.louiscad.resume.data.TitledTree
import com.louiscad.resume.data.content.FatResumeData

@Composable
actual fun LouisCadResume() {
    LouisCadResumeWithoutTheme()
    return
    @Suppress("UNREACHABLE_CODE")
    MaterialTheme(
        typography = MaterialTheme.typography.copy(
            body1 = TextStyle.Default.copy(letterSpacing = TextStyle.Default.letterSpacing * 1.1)
        )
    ) {}
}

@Composable
private fun Txt(
    text: String,
    color: Color = Color.Unspecified,
    fontStyle: FontStyle? = null,
    style: TextStyle = LocalTextStyle.current
) {
    @OptIn(ExperimentalUnitApi::class)
    Text(
        text,
        color = color,
        fontStyle = fontStyle,
        letterSpacing = TextUnit(value = .2f, type = TextUnitType.Sp),
        style = style
    )
}

@Composable
fun LouisCadResumeWithoutTheme() {
    Row(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(FatResumeData.name, style = MaterialTheme.typography.h4)
                Text(FatResumeData.title, style = MaterialTheme.typography.h5)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    FatResumeData.whatIAmLookingFor,
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    FatResumeData.desiredContract,
                    style = MaterialTheme.typography.body2
                )
                Spacer(modifier = Modifier.height(16.dp))
                Txt("Contact info:", style = MaterialTheme.typography.h6)
                FatResumeData.contactInfo.forEach { text -> Txt(text) }
                Spacer(modifier = Modifier.height(8.dp))
                Txt(FatResumeData.locationInfo)
                Spacer(modifier = Modifier.height(16.dp))
                FatResumeData.myLinks.forEach { text -> Txt(text) }
            }
            ResumeBranch(FatResumeData.whatILove())
            Column(modifier = Modifier.padding(16.dp)) {
                Txt(
                    "Please, keep in mind that this Resume is non-exhaustive.",
                    fontStyle = FontStyle.Italic
                )
                Spacer(modifier = Modifier.height(8.dp))
                Txt(
                    text = "Made with Jetpack Compose by Louis CAD.\n" +
                            "Thanks to Zach Klippenstein for the PDF conversion facilities in github.com/zach-klippenstein/compose-richtext",
                    fontStyle = FontStyle.Italic,
                    color = Color.Gray
                )
            }
        }
        Box(modifier = Modifier.weight(1.2f)) {
            ResumeBranch(FatResumeData.experience)
        }
        Box(modifier = Modifier.weight(0.8f)) {
            Column {
                ResumeBranch(FatResumeData.achievements)
                ResumeBranch(FatResumeData.skillsGeneral)
            }
        }
        Box(modifier = Modifier.weight(0.8f)) {
            ResumeBranch(FatResumeData.skillsDev)
        }
    }
}

@Composable
private fun ResumeBranch(tree: TitledTree<ResumeDataItem>) {
    when (tree) {
        is TitledTree.Branch -> ResumeSection(title = tree.title, borderColor = tree.color) {
            tree.nodes.forEach { ResumeBranch(it) }
        }
        is TitledTree.Leaf -> ResumeItem(tree.data)
    }
}
