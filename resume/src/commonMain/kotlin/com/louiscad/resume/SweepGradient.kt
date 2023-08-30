package com.louiscad.resume

data class SweepGradient(
    val angleInDegree: Int,
    val colors: List<UInt>
) {
    constructor(
        angleInDegree: Int,
        vararg colors: UInt
    ) : this(
        angleInDegree = angleInDegree,
        colors = colors.asList()
    )

    val backgroundCssValue by lazy {
        buildString {
            append("conic-gradient(from ")
            append(angleInDegree)
            append("deg, ")
            colors.forEach {
                append('#')
                append(it.toString(16).padStart(length = 6, padChar = '0'))
                append(',')
            }
            append('#')
            append(colors.first().toString(16).padStart(length = 6, padChar = '0'))
            append(')')
        }
    }

    companion object {
        val default = SweepGradient(63, 0xFF00FFu, 0x00FFFFu)
        val kotlin = SweepGradient(225, 0x7F52FFu, 0xC711E1u, 0xE44857u, 0xC711E1u)
        val google = SweepGradient(300) {
            val red = 0xE94436u; val blue = 0x4485F3u; val green = 0x119D58u; val yellow = 0xFBBB07u
            repeat(2) { add(red) }
            repeat(2) { add(green) }
            repeat(2) { add(yellow) }
            repeat(2) { add(blue) }
        }
        val android = SweepGradient(150, 0x1CE11Cu, 0x19D019u, 0x3EFD3Eu)
        val oss = SweepGradient(150, 0u)
        val speaking = SweepGradient(222, 0x960011u, 0xFF0018u)
        val love = SweepGradient(150, 0xFF0000u, 0xFF00FFu)
        val hobbies = SweepGradient(150, 0xD3D3D3u, 0x78FFFBu)
        val lessImportant = SweepGradient(330, 0xD3D3D3u, 0x78FFFBu, 0xD3D3D3u, 0xD3D3D3u, 0x78FFFBu, 0xD3D3D3u)
        val lessImportant2 = SweepGradient(258, 0xD3D3D3u, 0x78FFFBu, 0xD3D3D3u, 0xD3D3D3u, 0x78FFFBu, 0xD3D3D3u)
        val leastImportant = SweepGradient(115) {
            add(0x939393u)
            repeat(12) { add(0xD3D3D3u) }
        }

        @OptIn(ExperimentalStdlibApi::class)
        inline operator fun invoke(
            angleInDegree: Int,
            colors: MutableList<UInt>.() -> Unit
        ): SweepGradient {
            return SweepGradient(angleInDegree, colors = buildList(colors))
        }
    }
}
