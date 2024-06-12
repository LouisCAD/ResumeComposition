import org.jetbrains.compose.compose
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("multiplatform")
    kotlin("plugin.compose")
    id("org.jetbrains.compose")
    id("com.android.library")
}

group = "com.louiscad.resume"
version = property("thisProjectVersion") as String

kotlin {
    androidTarget()
    jvm("desktop") {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
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
//                api(compose.web.widgets)
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
        val androidUnitTest by getting {
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
    compileSdk = 34
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
    namespace = "com.louiscad.resume"
}
