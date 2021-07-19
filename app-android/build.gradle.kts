plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":resume"))
    implementation(AndroidX.activity.compose)
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
