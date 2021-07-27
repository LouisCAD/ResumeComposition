import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.application")
}

group = "com.louiscad.resume"
version = property("thisProjectVersion") as String

tasks.register<Copy>("buildForGitHubPages") {
    group = "kotlin browser"
    description = "This is a custom task (not from Kotlin Gradle plugin) that will " +
            "build the production website and put it in the docs directory."
    dependsOn("jsBrowserDistribution")
    from(layout.buildDirectory.dir("distributions"))
    into(rootProject.layout.projectDirectory.dir("docs"))
}

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        binaries.executable()
        browser()
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":resume"))
            }
        }
        val jvmMain by creating
        val androidMain by getting {
            dependsOn(jvmMain)
            dependencies {
                implementation(AndroidX.activity.compose)
            }
        }
        val desktopMain by getting {
            dependsOn(jvmMain)
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
        val desktopTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(project(":resume"))
                implementation("org.jetbrains.kotlinx:kotlinx-html:_")
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.louiscad.resume"
            packageVersion = property("desktopAppVersion") as String
        }
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        applicationId = "com.louiscad.resume"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = property("thisProjectVersion") as String
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
    }
}
