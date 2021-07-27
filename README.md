# ResumeComposition

## What

This project is the source code of the resume/CV of Louis CAD.

TK: put clickable thumbnail of the Resume.

It is built with Kotlin, Compose for Web, and also supports Jetpack Compose for Android, which shares code with a Desktop version.

To be more specific, the main Resume is made with Compose for Web because it can easily be tweaked and printed via the browser (including PDF export), and allows clickable links. This version is designed to fit on an ISO A4 sheet of paper.

The Android app has a version that doesn't display correctly on a typical mobile device, because it's designed to fill an ISO A3 sheet of paper. _Printing and PDF exporting functionality for the Android app is in another project at the moment. It will be integrated in this one in the coming days (should be done by August 2021)._

The Desktop app shares the code with the Android app. It allows previewing what the Android app would generate on a bigger screen. That said, some text is currently cut-off on laptop screens because ISO A3, the size it's been designed for, is much bigger. This target was more an experiment, a successful one, about code sharing rather than a goal to make a proper Desktop app for my Resume.

## Why

I made my Resume with Jetpack Compose for multiple reasons:

1. I didn't want it to look boring and like many other resumes, so using Google Docs or alike was discarded.
2. I didn't want to have to tweak the layout manually in Affinity Designer or Sketch, per (sub-)pixel, every time I'd change the content.
3. I wanted to get more experience with Jetpack Compose besides a few screens and embedded views I made at work with it.
4. I wanted to learn more about Compose for Web, and learn web development again, after putting these skills I had mostly aside for about 6 years.
5. I wanted to see how I could share code with a Web, Android and JVM app that also happened to use Jetpack Compose by Google and JetBrains.

## How

TK
