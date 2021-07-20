package com.louiscad.resume.data.content

import com.louiscad.resume.Color
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

    val whatIAmLookingFor = "Looking for a developer relations position focused on Kotlin"

    val desiredContract = "Desired contract: Part-time"

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
        title = "What I love",
        nodes = listOf(
            TitledTree.Branch(
                title = "At work, on projects, and generally speaking",
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
                title = "In software development",
                "API design",
                "OSS projects contributions and authoring",
                "Pair-programming and collaborating",
                "Reliability, efficiency, and maintainability",
                "Inspiring people (developers or not)",
                "Kotlin"
            ),
            TitledTree.Branch(
                title = "Activities/hobbies",
                "Science (learning and using)",
                "Understanding people in depth (sometimes)",
                "Recumbent cycling (that's also how I commute)",
                "Lego technic (custom builds)",
                "DIY (including electronics)"
            )
        )
    )

    val experience: TitledTree.Branch<ResumeDataItem> = TitledTree.Branch(
        title = "Experience",
        TitledTree.Branch(
            title = "Open source authoring",
            "[Splitties] (set of mini libraries for Android & Kotlin Multiplatform development), 1.8K stars on GitHub",
            "[refreshVersions](https://github.com/jmfayard/refreshVersions), Gradle plugin, almost 1K stars",
            "[CompleteKotlin](https://github.com/LouisCAD/CompleteKotlin), 161 stars since release in June 2021",
            "[beepiz-external-control-example](https://github.com/Beepiz/beepiz-external-control-example) (IPC on Android)",
            "[BleGattCoroutines](https://github.com/Beepiz/BleGattCoroutines) (Bluetooth Low Energy GATT client for Android)",
            "Draft projects: [CameraCoroutines](https://github.com/Beepiz/CameraCoroutines), [BleScanCoroutines](https://github.com/Beepiz/BleScanCoroutines) (draft)",
        ),
        TitledTree.Branch(
            title = "2014-2021 Android app developer at Beepiz (fulltime)",
            TitledTree.Branch(
                title = "Technologies used",
                "Java 7 (mostly until 2016)",
                "Kotlin (starting v1.0.4)",
                "Kotlin coroutines (since 2017)",
                "Gradle (including Gradle plugin development)",
            ),
            TitledTree.Branch(
                title = "Tasks",
                "Made 7 production apps (alone)",
                "Ensuring the reliability of 2 life critical apps",
                "Leveraging accelerometer data across many different devices",
                "Managing/replacing self-induced legacy code",
                "Providing a user permission guarded IPC API for customer Android apps to control ours",
                "Keeping Beepiz energy-efficient",
            )
        ),
        TitledTree.Branch(
            title = "Public speaking",
            "Gave 13 talks (6 in 🇬🇧 and 7 in 🇫🇷) on Kotlin, coroutines, Android, and WearOS between 2017 and 2021 " +
                    "at conferences like Android Makers, Talking.kt, Mobilization (PL), and FOSDEM, and at various meetups",
            "Was invited to 3 podcast episodes: Android Leaks twice, and The Developers Bakery once"
        )
    )

    val achievements: TitledTree.Branch<ResumeDataItem> = TitledTree.Branch(
        title = "Achievements",
        TitledTree.Branch(
            title = "Issue reporting",
            "Reported 190 Kotlin issues, with 107 resolved to date",
            "Reported 270 issues on Google's/Android's issue tracker, with 70 fixed to date"
        ),
        TitledTree.Branch(
            title = "Recognition",
            "Google Developer Expert for Kotlin since 2020"
        )
    )

    val skillsGeneral: TitledTree.Branch<ResumeDataItem> = TitledTree.Branch(
        title = "Skills (general)",
        TitledTree.Branch(
            title = "Communication",
            TitledTree.Branch(
                title = "Languages",
                "Fluent in English, French native",
                "Good at spotting misspellings and typos (incl. own)",
                "Comfortable speaking publicly"
            ),
            TitledTree.Branch(
                title = "Presentation tools",
                "Mind mapping tools",
                "Keynote with animations",
                "Google Slides"
            )
        ),
        TitledTree.Branch(
            title = "Vector graphics",
            "Familiar with Sketch (macOS app)",
            "Affinity Designer (light user so far)",
            "Can write SVG path data by hand",
        ),
        TitledTree.Branch(
            title = "3D modeling",
            "Familiar with Shapr3D (iPad & macOS app), with it, I can model the Kotlin logo in under 30s",
            "Getting started with Fusion 360",
        )
    )

    val skillsDev: TitledTree.Branch<ResumeDataItem> = TitledTree.Branch(
        title = "Skills (software development)",
        TitledTree.Branch(
            title = "Concepts",
            "Binary, hexadecimal representation",
            "Backwards and forward compatibility",
            "Code reuse",
            "Code readability",
            "Code and systems malleability",
            "Maintainability",
            "Migration",
            "Defensive programming",
        ),
        TitledTree.Branch(
            title = "Kotlin",
            "Coroutines (in depth)",
            "Multiplatform library development, including Kotlin/Native",
            "Scripting, partial and full automation",
            "Gradle plugin development (build automation)",
        ),
        TitledTree.Branch(
            title = "Android",
            TitledTree.Branch(
                title = "Specific skills",
                "Making entire mobile apps",
                "Making WearOS apps and WatchFaces",
                "IPC (inter-process-communication)",
                "Extensive knowledge about Android dev history"
            ),
            TitledTree.Branch(
                title = "APIs I'm familiar with",
                "android.view (programmatically)",
                "Jetpack Compose",
                "BLE (BluetoothLeScanner & BluetoothGatt)",
                "SensorManager",
                "Camera2",
                "Most of AndroidX",
                "Several/many other Android platform APIs"
            )
        ),
        TitledTree.Branch(
            title = "Experimenting with",
            "Swift, and Kotlin/Native interop",
            "iOS dev, including programmatic UIKit",
            "Compose for Web, and Compose for Desktop"
        )
    )
}
