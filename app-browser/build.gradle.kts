plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.louiscad.resume"
version = property("thisProjectVersion") as String

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
    sourceSets {
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
