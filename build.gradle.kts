buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:_")
        classpath("com.android.tools.build:gradle:_")
    }
}

group = "com.louiscad"
version = property("thisProjectVersion") as String

allprojects {
    repositories {
        mavenCentral()
        google()
    }
}
