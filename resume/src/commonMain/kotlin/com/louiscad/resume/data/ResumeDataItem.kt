package com.louiscad.resume.data

import com.louiscad.resume.Svg

sealed class ResumeDataItem {

    data class Text(val text: String) : ResumeDataItem()
    data class Line(val text: String, val icon: Svg? = null) : ResumeDataItem()

    data class Skill(
        val name: String,
        val experience: Experience? = null,
        val affinity: Affinity? = null
    ) {
        enum class Experience {
            Expert,
            Proficient,
            Familiar,
            Experimenting,
            Initiated
        }
        enum class Affinity {
            Love,
            Enjoy,
            PreferToAvoid
        }
    }
}

data class ResumeDataItem2(
    val year: String? = null,
    val month: String? = null,
    val mainText: String
) {
    init {
        if (month != null) requireNotNull(year) {
            "Month was supplied, without the year!"
        }
    }
}

