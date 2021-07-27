# ResumeComposition

## What

This project is the source code of the resume/CV of Louis CAD.

[The latest PDF export is available here.](Louis%20CAD%20Resume%202021-07-27.pdf)

Here's a _blurry picture_ that you can click to see the crisp PDF document:

[![](Louis%20Resume%202021-07-27.jpg)](Louis%20CAD%20Resume%202021-07-27.pdf)

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

If you just want to see the latest Resume, [it is here in PDF](Louis%20CAD%20Resume%202021-07-27.pdf).

### Building the project

**Warning:** If you want to explore the project in an IDE, it's best to use IntelliJ IDEA 2021.1 or later.
It might work in recent Android Studio versions as well, but it hasn't been tested there.

#### WEB version

##### Development mode

In development mode (no minification or deep dead code elimination), there are two ways to run the project:

If you just want to build the webpage, run the following command:
```shell
./gradlew :app:jsBrowserDevelopmentExecutableDistribution
```
Once the command completes, you'll find the resulting html and js files in the [app/build/developmentExecutable](app/build/developmentExecutable) directory.
You can simply open the [index.html](app/build/developmentExecutable/index.html) file in a WEB browser like Google Chrome or Mozilla Firefox to see the result.

If you want to have Gradle automatically rebuild on save, and refresh the page on compilation success, you can run the following command instead:

```shell
./gradlew --continuous :app:jsBrowserRun
```

It will wait for changes and build repeatedly until you stop it manually.

##### Production mode

As for development mode, there are two ways to run the production version of the project.
The production mode will take a bit longer to compile because it'll try to find dead/unused code and remove it from the output to save storage and bandwidth (if published online). This step is called Dead Code Elimination (DCE). On this project, the output size has been observed to be 10 times smaller with DCE (from 6.8 MB down to under 0.5 MB).

If you just want to build the webpage, run the following command:
```shell
./gradlew :app:jsBrowserDistribution
```

Once the command completes, you'll find the resulting html and js files in the [app/build/distributions](app/build/distributions) directory.
You can simply open the [index.html](app/build/distributions/index.html) file in a WEB browser like Google Chrome or Mozilla Firefox to see the result. The entire content of the directory can then be moved to a place that will serve the static files.

If you want to have Gradle automatically rebuild on save, and refresh the page on compilation success, you can run the following command instead:

```shell
./gradlew --continuous :app:jsBrowserProductionRun
```

It will wait for changes and build (with DCE) repeatedly until you stop it manually.

#### Android version

You can run the `app` module like any other Android app, but please, keep in mind that printing and PDF exporting is not integrated in the project in this repository yet, so you won't be able to see it correctly at all.

#### Desktop version

This version is not complete and doesn't layout properly on all screen sizes (not responsive yet), but can still be run like any other Compose for Desktop app.

## License

All rights reserved for Louis Cognault Ayeva Derman.

You can take inspiration from this project and take some code so long as:
1. You make sure your Resume doesn't look like mine (content, colors).
2. You don't make a Resume generator service with it without my approval (ask via email).

Feel free to ask via email if you're unsure if you'd violate this license.
