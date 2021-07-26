import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
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
        browser()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
            }
        }
        val commonTest by getting {
            /* // Commented out because it causes build to fail.
            dependencies {
                implementation(kotlin("test"))
            }
            */
        }
        val jvmMain by creating {
            dependsOn(commonMain)
            dependencies {
                api(compose.foundation)
                api(compose.material)
            }
        }
        val jsMain by getting {
            dependencies {
                api(compose.web.core)
                api(compose.web.widgets)
            }
        }
        val jsTest by getting
        val androidMain by getting {
            dependsOn(jvmMain)
            dependencies {
                api(AndroidX.appCompat)
                api(AndroidX.core.ktx)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(Testing.junit4)
            }
        }
        val desktopMain by getting {
            dependsOn(jvmMain)
        }
        val desktopTest by getting
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(30)
    }
}
