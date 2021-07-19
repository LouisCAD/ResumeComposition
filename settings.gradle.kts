pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
        jcenter()
    }
}

plugins {
    id("de.fayard.refreshVersions") version "0.10.1"
}

rootProject.name = "ResumeComposition"

include(":app")
include(":resume")
