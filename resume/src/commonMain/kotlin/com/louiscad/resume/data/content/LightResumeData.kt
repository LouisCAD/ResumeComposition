package com.louiscad.resume.data.content

import com.louiscad.resume.Svg
import com.louiscad.resume.SweepGradient
import com.louiscad.resume.Title
import com.louiscad.resume.data.invoke
import com.louiscad.resume.data.ResumeDataItem
import com.louiscad.resume.data.TitledTree

object LightResumeData {

    val columnsWeights = ColumnsWeights
    object ColumnsWeights {
        val whatILove = 1f
        val experience = 1f
        val skillsGeneral = 1f
        val skillsDev = 1f
    }

    val name = "Louis CAD"

    val title = "Senior software developer"

    val whatIAm = "Kotlin Multiplatform and Android expert, focused on reliability"

    val contactInfo: List<String> = listOf(
        "Email: [louis.cognault@gmail.com](mailto:louis.cognault@gmail.com)",
        "Phone: Ask via email",
    )

    val locationInfo = "Currently located in Tours, France"

    val myLinks: List<String> = listOf(
        "See my work on GitHub: [github.com/LouisCAD](https://github.com/LouisCAD)",
        "See my Twitter [@Louis_CAD](https://twitter.com/Louis_CAD)"
    )

    fun whatILove(): TitledTree.Branch<ResumeDataItem> = TitledTree.Branch(
        title = Title("What I love - values", Svg("heart")),
        nodes = listOf(
            TitledTree.Branch(
                title = Title("At work, on projects, and generally speaking"),
                borderGradient = SweepGradient.love,
                "Innovating, ideating, and contributing to what I believe in.",
                "Simplifying complex things",
                "Questioning the status quo",
                "Expanding my knowledge, and sharing it back",
                "Spreading improvement (and scaling it with software where applicable and appropriate)",
                "Keeping relationships and people healthy",
                "Technical things, so long they are useful",
                "Ensuring attention is paid to the important details",
                "Efficiency (energy, time)",
                "Helping others, in my social circle and beyond",
                "Having fun while doing all of the above"
            ),
            TitledTree.Branch(
                title = Title("In software development", Svg("code-braces")),
                borderGradient = SweepGradient.love,
                "API design",
                "OSS projects contributions and authoring",
                "Pair-programming and collaborating",
                "Reliability, efficiency, and maintainability",
                "Inspiring people (developers or not)",
                "Well designed programming languages like Kotlin, Swift, and Rust"
            ),
            TitledTree.Branch(
                title = Title("Activities/hobbies", Svg("cards-playing")),
                borderGradient = SweepGradient.hobbies,
                "Science (learning and using)",
                "Understanding people in depth (sometimes)",
                "Recumbent cycling (that's also how I commute)",
                "Lego technic (custom builds)",
                "DIY (including electronics)"
            )
        )
    )

    val experience: TitledTree.Branch<ResumeDataItem> = TitledTree.Branch(
        title = Title("Experience", Svg("briefcase")),
        TitledTree.Branch(
            title = Title("Open source authoring", Svg("github")),
            borderGradient = SweepGradient.oss,
            "[Splitties](https://github.com/LouisCAD/Splitties) (set of mini libraries for Android & Kotlin Multiplatform development), 2.4K stars on GitHub",
            "[refreshVersions](https://github.com/jmfayard/refreshVersions), Gradle plugin, almost 1.6K stars",
            "[CompleteKotlin](https://github.com/LouisCAD/CompleteKotlin), 265 stars since release in June 2021",
            "[beepiz-external-control](https://github.com/Beepiz/beepiz-external-control) (IPC on Android)",
            "[BleGattCoroutines](https://github.com/Beepiz/BleGattCoroutines) (Bluetooth Low Energy GATT client for Android), 448 stars",
            "Draft projects: [CameraCoroutines](https://github.com/Beepiz/CameraCoroutines), [BleScanCoroutines](https://github.com/Beepiz/BleScanCoroutines) (draft)",
        ),
        TitledTree.Branch(
            title = Title("2014-2022 Android app developer at Beepiz (fulltime)"),
            TitledTree.Branch(
                title = Title("Technologies used", Svg("code-tags-check")),
                "Java 7 (mostly until 2016)",
                "Kotlin (starting v1.0.4)",
                "Kotlin coroutines (since 2017)",
                "Kotlin Multiplatform (since 2020)",
                "Gradle (including Gradle plugin development)",
            ),
            TitledTree.Branch(
                title = Title("Tasks", Svg("check-all")),
                "Made 7 production apps (alone)",
                "Ensuring the reliability of 2 life critical apps",
                "Leveraging accelerometer data across many different devices",
                "Managing/replacing self-induced legacy code",
                "Providing a user permission guarded IPC API for customer Android apps to control ours",
                "Keeping Beepiz energy-efficient",
            )
        ),
        TitledTree.Branch(
            title = Title("Public speaking", Svg("microphone-variant")),
            borderGradient = SweepGradient.speaking,
            "Gave 27 talks (17 in 🇬🇧 and 10 in 🇫🇷) on Kotlin, coroutines, Android, and WearOS between 2017 and 2023 " +
                    "at conferences like Droidcon, Android Makers, DevFest, Talking.kt, Mobilization (PL), and FOSDEM, and at various meetups",
            "Participated in 3 podcast episodes: Android Leaks twice, and The Developers Bakery once"
        )
    )

    val achievements: TitledTree.Branch<ResumeDataItem> = TitledTree.Branch(
        title = Title("Achievements", Svg("trophy-award")),
        TitledTree.Branch(
            title = Title("Issue reporting", Svg("alert-circle-check-outline")),
            borderGradient = SweepGradient.oss,
            "Reported 202 Kotlin issues on YouTrack, with 126 resolved to date",
            "Reported 295 issues on Google's/Android's issue tracker, with 81 fixed to date"
        ),
        TitledTree.Branch(
            title = Title("Recognition", Svg("certificate")),
            borderGradient = SweepGradient.google,
            "[Google Developer Expert](https://g.dev/louiscad) for Kotlin since 2020"
        )
    )

    val skillsGeneral: TitledTree.Branch<ResumeDataItem> = TitledTree.Branch(
        title = Title("Skills (general)", Svg("palette-swatch")),
        TitledTree.Branch(
            title = Title("Communication", Svg("forum-outline")),
            borderGradient = SweepGradient.lessImportant,
            TitledTree.Branch(
                title = Title("Languages", Svg("flag-variant")),
                "Fluent in English, French native",
                "Good at spotting misspellings and typos (incl. own)",
                "Comfortable speaking publicly"
            ),
            TitledTree.Branch(
                title = Title("Presentation tools", Svg("presentation-play")),
                "Mind mapping tools",
                "Keynote with animations",
                "Google Slides"
            )
        ),
        TitledTree.Branch(
            title = Title("Vector graphics", Svg("vector-curve")),
            borderGradient = SweepGradient.lessImportant2,
            "Familiar with Sketch (macOS app)",
            "Affinity Designer (light user so far)",
            "Can write SVG path data by hand",
        ),
        TitledTree.Branch(
            title = Title("3D modeling", Svg("cube-outline")),
            borderGradient = SweepGradient.leastImportant,
            "Familiar with Shapr3D (iPad & macOS app), with it, I can model the Kotlin logo in under 30s",
            "Getting started with Fusion 360",
        )
    )

    val madeWith = "Made in Kotlin with Compose for Web\n" +
            "See the code and the Android version on [github.com/LouisCAD/ResumeComposition](https://github.com/LouisCAD/ResumeComposition)"

    val skillsDev: TitledTree.Branch<ResumeDataItem> = TitledTree.Branch(
        title = Title("Skills (software dev)", Svg("math-compass")),
        TitledTree.Branch(
            title = Title("Concepts", Svg("shape-plus")),
            "Binary, hexadecimal representation" to Svg("data-matrix"),
            "Backwards and forward compatibility" to Svg("swap-horizontal-bold"),
            "Code reuse" to Svg("recycle"),
            "Code readability - mental load" to Svg("head-cog-outline"),
            "Code and systems malleability" to Svg("shape"),
            "Maintainability" to Svg("tools"),
            "Migration" to Svg("arrow-up-bold-circle"),
            "Defensive programming" to Svg("security"),
        ),
        TitledTree.Branch(
            title = Title("Kotlin", Svg("language-kotlin")),
            borderGradient = SweepGradient.kotlin,
            "Coroutines (in depth)",
            "Multiplatform library development, including Kotlin/Native",
            "Scripting, partial and full automation",
            "Gradle plugin development (build automation)",
        ),
        TitledTree.Branch(
            title = Title("Android", Svg("android")),
            borderGradient = SweepGradient.android,
            TitledTree.Branch(
                title = Title("Specific skills"),
                "Making entire mobile apps",
                "Making WearOS apps and WatchFaces",
                "IPC (inter-process-communication)",
                "Extensive knowledge about Android dev history"
            ),
            TitledTree.Branch(
                title = Title("APIs I'm familiar with"),
                "Jetpack Compose",
                "android.view (programmatically)",
                "BLE (BluetoothLeScanner & BluetoothGatt)",
                "SensorManager",
                "CameraX & Camera2",
                "Most of AndroidX",
                "Several/many other Android platform APIs"
            )
        ),
        TitledTree.Branch(
            title = Title("Experimenting with", Svg("flask-outline")),
            borderGradient = SweepGradient.leastImportant,
            "Swift, and Kotlin/Native interop",
            "iOS dev, including programmatic UIKit",
            "Compose HTML, and Compose for Desktop"
        )
    )
}
