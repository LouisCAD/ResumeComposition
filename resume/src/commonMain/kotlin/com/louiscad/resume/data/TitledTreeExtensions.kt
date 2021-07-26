package com.louiscad.resume.data

import com.louiscad.resume.Color
import com.louiscad.resume.ImageVector


internal operator fun TitledTree.Branch.Companion.invoke(
    title: String,
    color: Color? = null,
    vararg textNodes: String
): TitledTree.Branch<ResumeDataItem> {
    return TitledTree.Branch(
        title = title,
        color = color,
        nodes = textNodes.asList().map { TitledTree.Leaf(ResumeDataItem.Text(it)) }
    )
}

internal operator fun TitledTree.Branch.Companion.invoke(
    title: String,
    vararg textNodes: String
): TitledTree.Branch<ResumeDataItem> {
    return TitledTree.Branch(
        title = title,
        nodes = textNodes.asList().map { TitledTree.Leaf(ResumeDataItem.Text(it)) }
    )
}

internal operator fun TitledTree.Branch.Companion.invoke(
    title: String,
    useKotlinColors: Boolean,
    vararg textNodes: String
): TitledTree.Branch<ResumeDataItem> {
    return TitledTree.Branch(
        title = title,
        useKotlinColors = useKotlinColors,
        nodes = textNodes.asList().map { TitledTree.Leaf(ResumeDataItem.Text(it)) }
    )
}

internal operator fun TitledTree.Branch.Companion.invoke(
    title: String,
    vararg lines: Pair<String, ImageVector?>
): TitledTree.Branch<ResumeDataItem> {
    return TitledTree.Branch(
        title = title,
        nodes = lines.asList().map { (text, icon) -> TitledTree.Leaf(ResumeDataItem.Line(text, icon)) }
    )
}
