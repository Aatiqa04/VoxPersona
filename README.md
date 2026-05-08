# VoxPersona

An Android library/reading app written in Java. Users sign up, browse a curated catalog of books, search the library, and view notifications — all behind a bottom-navigation shell.

## Features

- **Splash screen** branded launch screen on app start
- **Sign up** account entry flow
- **Home** landing screen after authentication
- **Library** scrollable list of books rendered with `RecyclerView`
- **Search** find books in the catalog
- **Notifications** in-app notification feed
- **Bottom navigation** for switching between Home, Search, Library, and Notifications

## Tech stack

- **Language:** Java 8
- **Platform:** Android (`minSdk` 24, `targetSdk` 34, `compileSdk` 34)
- **Build:** Gradle (Kotlin DSL) with the version catalog (`gradle/libs.versions.toml`)
- **UI:** AndroidX AppCompat, Material Components, ConstraintLayout, Navigation Component, View Binding

## Project structure

```
VoxPersona/
├── app/
│   ├── build.gradle.kts
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/example/voxpersona/
│       │   ├── SplashActivity.java
│       │   ├── SignUpActivity.java
│       │   ├── MainActivity.java
│       │   ├── HomeActivity.java
│       │   ├── LibraryActivity.java
│       │   ├── SearchActivity.java
│       │   ├── NotificationsActivity.java
│       │   ├── Book.java / BookAdapter.java
│       │   └── Notification.java / NotificationAdapter.java
│       └── res/                # layouts, drawables, themes
├── pictures/                   # source artwork and book covers
├── build.gradle.kts
├── settings.gradle.kts
└── gradlew / gradlew.bat
```

## Getting started

### Prerequisites

- Android Studio (Hedgehog or newer recommended)
- JDK 8+
- Android SDK Platform 34 installed

### Build & run

Clone and open the project in Android Studio, then run the `app` configuration on an emulator or device with API 24+.

From the command line:

```bash
# Windows
gradlew.bat assembleDebug

# macOS / Linux
./gradlew assembleDebug
```

Install the resulting APK from `app/build/outputs/apk/debug/` onto a connected device:

```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Tests

```bash
./gradlew test                 # unit tests
./gradlew connectedAndroidTest # instrumented tests (requires a device/emulator)
```

## App flow

`SplashActivity` is the launcher entry point. From there the user moves through `SignUpActivity` into `HomeActivity`, where the bottom navigation bar lets them switch between `HomeActivity`, `SearchActivity`, `LibraryActivity`, and `NotificationsActivity`.

The library is currently populated with a hardcoded sample catalog inside `LibraryActivity.loadBooks()` — swap this for a real data source (Room, Retrofit, etc.) when wiring up a backend.
