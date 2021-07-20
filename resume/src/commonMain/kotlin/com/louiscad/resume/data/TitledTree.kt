package com.louiscad.resume.data

import com.louiscad.resume.Color

sealed class TitledTree<LeafT>() {
    data class Branch<LeafT>(
        val title: String,
        val color: Color? = null,
        val nodes: List<TitledTree<LeafT>>
    ) : TitledTree<LeafT>() {

        constructor(
            title: String,
            color: Color?,
            vararg nodes: TitledTree<LeafT>
        ) : this(title, color, nodes.asList())

        constructor(
            title: String,
            vararg nodes: TitledTree<LeafT>
        ) : this(title, null, nodes.asList())

        companion object
    }

    data class Leaf<LeafT>(
        val data: LeafT
    ) : TitledTree<LeafT>()
}
