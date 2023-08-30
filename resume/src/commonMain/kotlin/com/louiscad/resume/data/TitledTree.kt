package com.louiscad.resume.data

import com.louiscad.resume.Color
import com.louiscad.resume.SweepGradient
import com.louiscad.resume.Title

sealed class TitledTree<LeafT>() {
    data class Branch<LeafT>(
        val title: Title,
        val borderGradient: SweepGradient = SweepGradient.default,
        val color: Color? = null,
        val nodes: List<TitledTree<LeafT>>
    ) : TitledTree<LeafT>() {

        constructor(
            title: Title,
            color: Color?,
            vararg nodes: TitledTree<LeafT>
        ) : this(title = title, color = color, nodes = nodes.asList())

        constructor(
            title: Title,
            color: Color?,
            borderGradient: SweepGradient,
            vararg nodes: TitledTree<LeafT>
        ) : this(
            title = title,
            borderGradient = borderGradient,
            color = color,
            nodes = nodes.asList()
        )

        constructor(
            title: Title,
            vararg nodes: TitledTree<LeafT>
        ) : this(
            title = title,
            color = null,
            nodes = nodes.asList()
        )

        constructor(
            title: Title,
            borderGradient: SweepGradient = SweepGradient.default,
            vararg nodes: TitledTree<LeafT>
        ) : this(
            title = title,
            borderGradient = borderGradient,
            color = null,
            nodes = nodes.asList()
        )

        companion object
    }

    data class Leaf<LeafT>(
        val data: LeafT
    ) : TitledTree<LeafT>()
}
