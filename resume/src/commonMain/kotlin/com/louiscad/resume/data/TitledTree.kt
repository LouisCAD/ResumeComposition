package com.louiscad.resume.data

import com.louiscad.resume.Color

sealed class TitledTree<LeafT>() {
    data class Branch<LeafT>(
        val title: String,
        val useKotlinColors: Boolean = false,
        val color: Color? = null,
        val nodes: List<TitledTree<LeafT>>
    ) : TitledTree<LeafT>() {

        constructor(
            title: String,
            color: Color?,
            vararg nodes: TitledTree<LeafT>
        ) : this(title = title, color = color, nodes = nodes.asList())

        constructor(
            title: String,
            color: Color?,
            useKotlinColors: Boolean,
            vararg nodes: TitledTree<LeafT>
        ) : this(
            title = title,
            useKotlinColors = useKotlinColors,
            color = color,
            nodes = nodes.asList()
        )

        constructor(
            title: String,
            vararg nodes: TitledTree<LeafT>
        ) : this(
            title = title,
            color = null,
            nodes = nodes.asList()
        )

        constructor(
            title: String,
            useKotlinColors: Boolean,
            vararg nodes: TitledTree<LeafT>
        ) : this(
            title = title,
            useKotlinColors = useKotlinColors,
            color = null,
            nodes = nodes.asList()
        )

        companion object
    }

    data class Leaf<LeafT>(
        val data: LeafT
    ) : TitledTree<LeafT>()
}
