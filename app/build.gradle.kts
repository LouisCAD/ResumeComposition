import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.application")
}

group = "com.louiscad.resume"
version = property("thisProjectVersion") as String

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
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
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
