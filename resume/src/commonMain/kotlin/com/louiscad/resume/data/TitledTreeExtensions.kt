package com.louiscad.resume.data

import com.louiscad.resume.*


internal operator fun TitledTree.Branch.Companion.invoke(
    title: Title,
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
    title: Title,
    vararg textNodes: String
): TitledTree.Branch<ResumeDataItem> {
    return TitledTree.Branch(
        title = title,
        nodes = textNodes.asList().map { TitledTree.Leaf(ResumeDataItem.Text(it)) }
    )
}

internal operator fun TitledTree.Branch.Companion.invoke(
    title: Title,
    borderGradient: SweepGradient,
    vararg textNodes: String
): TitledTree.Branch<ResumeDataItem> {
    return TitledTree.Branch(
        title = title,
        borderGradient = borderGradient,
        nodes = textNodes.asList().map { TitledTree.Leaf(ResumeDataItem.Text(it)) }
    )
}

internal operator fun TitledTree.Branch.Companion.invoke(
    title: Title,
    vararg lines: Pair<String, Svg?>
): TitledTree.Branch<ResumeDataItem> {
    return TitledTree.Branch(
        title = title,
        nodes = lines.asList().map { (text, icon) -> TitledTree.Leaf(ResumeDataItem.Line(text, icon)) }
    )
}

internal operator fun TitledTree.Branch.Companion.invoke(
    title: Title,
    borderGradient: SweepGradient,
    vararg lines: Pair<String, Svg?>
): TitledTree.Branch<ResumeDataItem> {
    return TitledTree.Branch(
        title = title,
        borderGradient = borderGradient,
        nodes = lines.asList().map { (text, icon) -> TitledTree.Leaf(ResumeDataItem.Line(text, icon)) }
    )
}
