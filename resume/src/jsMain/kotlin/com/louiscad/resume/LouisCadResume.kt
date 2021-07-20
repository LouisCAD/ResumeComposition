package com.louiscad.resume

import androidx.compose.runtime.Composable
import com.louiscad.resume.data.ResumeDataItem
import com.louiscad.resume.data.TitledTree
import com.louiscad.resume.data.content.FatResumeData
import com.louiscad.resume.data.content.LightResumeData
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontFamily
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.media
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.selectors.descendant
import org.jetbrains.compose.web.css.selectors.selector
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.H5
import org.jetbrains.compose.web.dom.H6
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

object ResumeStyleSheet : StyleSheet() {
    init {
        "p" {
            fontSize(11.px)
            property("margin-block", 0)
        }
        "h1, h2, h3, h4, h5, h6" {
            property("margin-block", 0)
            fontWeight(400)
        }
        "h1" {
            fontSize(20.px)
            fontFamily("Overpass", "sans-serif")
        }
        "h2" {
            fontSize(18.px)
            fontFamily("Overpass", "sans-serif")
        }
        "h3" { fontSize(16.px) }
        "h4" { fontSize(14.px) }
        "h5" { fontSize(13.px) }
    }

    val root by style {
        fontFamily("Roboto", "sans-serif")
        fontWeight(400)
        property("white-space", "pre-line")
        media("print") {
            margin((-10).px)
        }
    }
    val resumeSection by style {
        "h1, h2, h3, h4, h5, h6".split(", ").map {
            descendant(self, selector(it))
        }.joinToString() style {
            textAlign("center")
            property("margin-block-start", 8.px)
            property("margin-block-end", 8.px)
        }
    }
}

@Composable
actual fun LouisCadResume() {
    Style(ResumeStyleSheet)
    val resumeData = LightResumeData
    Div({
        classes(ResumeStyleSheet.root)
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
        }
    }) {
        Flex(weight = resumeData.columnsWeights.whatILove) {
            Div({
                style {
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Column)
                    margin(10.px)
                }
            }) {
                H1 { Text(resumeData.name) }
                H2 ({
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
                classes(ResumeStyleSheet.resumeSection)
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
    cssClass = ResumeStyleSheet.resumeSection,
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
        is TitledTree.Branch -> ResumeSection(title = tree.title) {
            tree.nodes.forEach { ResumeBranch(it) }
        }
        is TitledTree.Leaf -> ResumeItem(tree.data)
    }
}
