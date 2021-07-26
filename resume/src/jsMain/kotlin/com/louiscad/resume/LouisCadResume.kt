package com.louiscad.resume

import androidx.compose.runtime.Composable
import com.louiscad.resume.data.ResumeDataItem
import com.louiscad.resume.data.TitledTree
import com.louiscad.resume.data.content.LightResumeData
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontFamily
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

val resumeStyleSheet: ResumeStyleSheet = LouisCadResumeStyleSheet

@Composable
actual fun LouisCadResume() {
    Style(resumeStyleSheet)
    val resumeData = LightResumeData
    Div({
        classes(resumeStyleSheet.root)
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
        }
    }) {
        Flex(weight = resumeData.columnsWeights.whatILove) {
            Div({
                classes(resumeStyleSheet.nonSectionColumn)
            }) {
                H1 { Text(resumeData.name) }
                H2({
                    style { fontFamily("Roboto"); fontSize(14.px); fontWeight(300) }
                }) { Text(resumeData.whatIAmLookingFor) }
                P { Text(resumeData.desiredContract) }
                P {
                    LinkableText(resumeData.contactInfo.joinToString(separator = "\n"))
                }
                P { LinkableText(resumeData.locationInfo) }
                P({
                    style {
                        property("white-space", "pre-line")
                    }
                }) { LinkableText(resumeData.myLinks.joinToString(separator = "\n")) }
            }
            Div({
                classes(resumeStyleSheet.sectionsColumn)
            }) {
                ResumeBranch(resumeData.whatILove())
            }
        }
        ResumeColumn(weight = resumeData.columnsWeights.experience) {
            ResumeBranch(resumeData.experience)
        }
        ResumeColumn(weight = resumeData.columnsWeights.skillsGeneral) {
            Div({
                style {
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Column)
                }
            }) {
                ResumeBranch(resumeData.achievements)
                ResumeBranch(resumeData.skillsGeneral)
                Div({
                    classes(resumeStyleSheet.nonSectionColumn)
                }) {
                    P({
                        style { textAlign("center") }
                    }) {
                        LinkableText(resumeData.madeWith)
                    }
                }
            }
        }
        ResumeColumn(weight = resumeData.columnsWeights.skillsDev) {
            ResumeBranch(resumeData.skillsDev)
        }
    }
}

@Composable
private fun ResumeColumn(
    weight: Float = 1f,
    content: @Composable () -> Unit
) = Flex(
    weight = weight,
    cssClass = resumeStyleSheet.sectionsColumn,
    content = content
)

@Composable
private fun Flex(
    weight: Float = 1f,
    cssClass: String? = null,
    content: @Composable () -> Unit
) {
    Div({
        if (cssClass != null) classes(cssClass)
        style {
            this.property("flex", weight)
        }
    }) {
        content()
    }
}

@Composable
private fun ResumeBranch(tree: TitledTree<ResumeDataItem>) {
    when (tree) {
        is TitledTree.Branch -> ResumeSection(
            title = tree.title,
            useKotlinColors = tree.useKotlinColors
        ) {
            tree.nodes.forEach { ResumeBranch(it) }
        }
        is TitledTree.Leaf -> ResumeItem(tree.data)
    }
}
