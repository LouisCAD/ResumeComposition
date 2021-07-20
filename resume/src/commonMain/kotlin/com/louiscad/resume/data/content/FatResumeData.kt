package com.louiscad.resume.data.content

import com.louiscad.resume.Color
import com.louiscad.resume.data.ResumeDataItem
import com.louiscad.resume.data.TitledTree
import com.louiscad.resume.data.invoke

object FatResumeData {

    val columnsWeights = ColumnsWeights
    object ColumnsWeights {
        val whatILove = 1f
        val experience = 1.2f
        val skillsGeneral = 0.8f
        val skillsDev = 0.8f
    }

    object Colors {
        val darkGray = Color(0xFF_424242)
        val gray = Color(0xFF_A2A2A2)
        val ktPurple = gray

        //    val ktPurple = Color(0xFF_C3_16_E3)
        val actualKtPurple = Color(0xFF_C3_16_E3)

        val androidGreen = Color(0xFF_3D_DC_84)
        val someDarkGreen = Color(0xFF2E7D32)
        val someDarkBlue = Color(0xFF2979FF)
        val someDarkCyan = Color(0xFF0091EA)
        val somePurple = Color(0xFF8051FF)
        val someDarkColor = Color(0xFF01579B)

        val bpzYellow = Color(0xFF_FFC107)
        val someOrange = Color(0xFFFFAB00)

        val loveRed = Color(0xFF_CA0000)
        val someRed = Color(0xFFE24660)
    }

    val name = "Louis CAD"

    val title = "Senior software developer"

    val whatIAmLookingFor = "Looking for a developer relations position focused on Kotlin"

    val desiredContract = "Desired contract: Part-time"

    val contactInfo: List<String> = listOf(
        "Email: louis.cognault@gmail.com",
        "Telegram: @louiscad",
        "Phone: Ask via email to schedule a video or phone call",
    )

    val locationInfo = "Currently location in Tours, France, open to relocation"

    val myLinks: List<String> = listOf(
        "See my work on GitHub: github.com/LouisCAD",
        "See my involvement in the community on Twitter @Louis_CAD and on Kotlin's Slack @louiscad"
    )

    fun whatILove(): TitledTree.Branch<ResumeDataItem> = TitledTree.Branch(
        title = "What I love",
        color = Colors.darkGray,
        nodes = listOf(
            TitledTree.Branch(
                title = "At work, on projects, and generally speaking",
                color = Colors.ktPurple,
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
                color = Colors.gray,
                "API design",
                "OSS projects contributions and authoring",
                "Pair-programming and collaborating",
                "Reliability, efficiency, and maintainability",
                "Inspiring people (developers or not)",
                "Kotlin"
            ),
            TitledTree.Branch(
                title = "Activities/hobbies",
                color = Colors.gray,
                //color = Color(0xFFE91ED5),
                "Science (learning and using)",
                "Understanding people in depth (sometimes)",
                "Recumbent cycling (that's also how I commute)",
                "Lego technic (custom builds)",
                "DIY",
                "Listening to music",
                "Playing music (Piano, Oboe, and whatever can make beats)",
                "Swimming",
                "Sport (practice, not watching)",
                "Watching movies (a few)",
            )
        )
    )

    val experience: TitledTree.Branch<ResumeDataItem> = TitledTree.Branch(
        title = "Experience",
        color = Colors.darkGray,
        TitledTree.Branch(
            title = "Open source authoring",
            color = Colors.ktPurple,
            "Splitties (set of mini libraries for Android & Kotlin Multiplatform development)",
            "refreshVersions (gradle plugin to easily discover and perform upgrades of dependency versions in Kotlin or other Gradle projects)",
            "CompleteKotlin (allows to develop Kotlin/Native apps regardless of the developer's machine OS)",
            "beepiz-external-control-example (Does inter-app communication, i.e. IPC, with coroutines)",
            "BleGattCoroutines",
            "BleScanCoroutines (draft)",
            "CameraCoroutines (draft)",
        ),
        TitledTree.Branch(
            title = "2014-2021 Android app developer at Beepiz (fulltime)",
            color = Colors.ktPurple,
            TitledTree.Branch(
                title = "Technologies used",
                color = Colors.gray,
                "Java 7 (mostly until 2016)",
                "Kotlin (starting v1.0.4)",
                "Kotlin coroutines (since 2017)",
                "Gradle (including Gradle plugin development)",
            ),
            TitledTree.Branch(
                title = "Tasks",
                color = Colors.gray,
                "Made 7 production apps (alone)",
                "Ensuring the reliability of 2 life critical apps for lone workers",
                "Leveraging accelerometer data across many different devices",
                "Managing/replacing self-induced legacy code over 6+ years",
                "Providing a user permission guarded IPC API for customer Android apps to control ours",
                "Keeping Beepiz energy-efficient to ensure day-long operation",
            )
        ),
        TitledTree.Branch(
            title = "Public speaking",
            color = Color(0xFFA2A2A2),
            "🇫🇷 2021-06 FRAUG (French Android User Group): Google I/O debrief on Twitch, I focused on WearOS news",
            "🇬🇧 2021-05 The Developers Bakery (Podcast episode) hosted by Nicola Corti: refreshVersions (Listen at thebakery.dev/12)",
            "🇬🇧 2021-02 FOSDEM Kotlin Devroom: The future of dependency management, seen from 2021 (pre-recorded at home)",
            "🇬🇧 2020-03 Talking.kt Paris: refreshVersions: why, how it was born, and how it works",
            "🇫🇷 2019-12 JUG & GDG Tours: Débloquez la situation avec les coroutines de Kotlin (live demo of coroutines in UI on watchOS and iOS)",
            "🇬🇧 2019-10 Kotlin Day London: Coroutines everywhere for lazy developers (live demo of coroutines in UI on watchOS and iOS)",
            "🇫🇷 2019-10 Android Lille at Scaleway: Les coroutines, une révolution industrielle pour Android",
            "🇫🇷 2019-10 Kotlin/Everywhere Paris: Étude d'une bibliothèque à base de coroutines",
            "🇫🇷 2019-10 Kotlin/Everywhere Paris: Workshop on coroutines with Geoffrey Métais from VideoLabs (VLC)",
            "🇬🇧 2019-04 Android Makers: Making any codebase more readable with Kotlin coroutines",
            "🇫🇷 2018-11 Android Rennes 2018: Escaping Callback Hell with coroutines (live coding)",
            "🇬🇧 2018-10 Mobilization in Łódź, Poland 2018: If callbacks are hell, are coroutines the way to heaven?",
            "🇬🇧 2018-10 Lunatech 2018 in Rotterdam (company-internal): If callbacks are hell, are coroutines the way to heaven?",
            "🇫🇷 2017-02 GDG Tours: Kotlin Tour d'horizon (overview of Kotlin)",
        )
    )

    val achievements: TitledTree.Branch<ResumeDataItem> = TitledTree.Branch(
        title = "Achievements",
        color = Colors.darkGray,
        TitledTree.Branch(
            title = "Issue reporting",
            color = Colors.gray,
            "Reported 190 Kotlin issues, with 107 resolved to date",
            "Reported 270 issues on Google's/Android's issue tracker, with 70 fixed to date"
        ),
        TitledTree.Branch(
            title = "Recognition",
            color = Colors.ktPurple,
            "Google Developer Expert for Kotlin since 2020, referred by Kathrin Petrova from JetBrains"
        )
    )

    val skillsGeneral: TitledTree.Branch<ResumeDataItem> = TitledTree.Branch(
        title = "Skills (general)",
        color = Colors.darkGray,
        TitledTree.Branch(
            title = "Communication",
            color = Colors.ktPurple,
            TitledTree.Branch(
                title = "Languages",
                color = Colors.gray,
                "Fluent in English, French native",
                "I can quickly spot misspellings and typos, including my own as I write.",
                "Comfortable speaking publicly, can express myself with no latency.",
                "Might struggle to understand spoken English in some contexts (also linked to infantile hearing loss)"
            ),
            TitledTree.Branch(
                title = "Presentation tools",
                color = Colors.gray,
                "Mind mapping tools",
                "Keynote with animations (macOS/iPadOS app)",
                "Google Slides",
                "Jetpack Compose (Desktop, Android and Web), getting started"
            )
        ),
        TitledTree.Branch(
            title = "Vector graphics",
            color = Colors.gray,
            "Familiar with Sketch (macOS app by Bohemian Coding)",
            "Affinity Designer (light user so far)",
            "Can write SVG path data by hand (not proficiently yet)",
        ),
        TitledTree.Branch(
            title = "3D modeling",
            color = Colors.gray,
            "Familiar with Shapr3D (iPad & macOS app), with it, I can model the Kotlin logo in under 30s",
            "Getting started with Fusion 360",
        )
    )

    val skillsDev: TitledTree.Branch<ResumeDataItem> = TitledTree.Branch(
        title = "Skills (software development)",
        color = Colors.darkGray,
        TitledTree.Branch(
            title = "Concepts",
            color = Colors.gray,
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
            color = Colors.ktPurple,
            "Coroutines (including channels, semaphores, mutexes, select, flow and all sorts of callback wrapping)",
            "Multiplatform library development, including Kotlin/Native",
            "Scripting, partial and full automation",
            "Gradle plugin development (build automation)",
        ),
        TitledTree.Branch(
            title = "Android",
            color = Colors.ktPurple,
            TitledTree.Branch(
                title = "Specific skills",
                color = Colors.gray,
                "Making entire mobile apps",
                "Making WearOS apps and WatchFaces",
                "IPC (inter-process-communication)",
                "Extensive knowledge about Android dev history"
            ),
            TitledTree.Branch(
                title = "APIs I'm familiar with",
                color = Colors.gray,
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
            color = Colors.ktPurple,
            "Swift, and Kotlin/Native interop",
            "iOS dev, including programmatic UIKit",
            "Compose for Web",
            "Compose for Desktop",
        ),
        TitledTree.Branch(
            title = "I also know about",
            color = Colors.gray,
            "SQLite (fairly knowledgeable about it)",
            "Protobuf (& flatbuffers)",
            "Java (very familiar with it)",
            "Firebase and Google Cloud Platform",
            "MySQL (used 7 years ago)",
            "HTML5 & CSS3 and Web development",
            "PHP (made a backend with it 7 years ago)",
        )
    )
}
