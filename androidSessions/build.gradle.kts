plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp") version "1.6.10-1.0.2"
}

kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.example.sessions.android"
        minSdk = Versions.androidMinSdk
        targetSdk = Versions.androidTargetSdk
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))

    with(Deps.Accompanist) {
        implementation(systemUiController)
        implementation(insets)
    }

    with(Deps.Android) {
        implementation(material)
    }

    with(Deps.AndroidX) {
        implementation(lifecycleViewmodelKtx)
        implementation(lifecycleRuntimeKtx)
        implementation(activityCompose)
        implementation(material)
        implementation(splashScreen)
    }

    with(Deps.Compose) {
        implementation(coil)
        implementation(compiler)
        implementation(ui)
        implementation(uiGraphics)
        implementation(uiTooling)
        implementation(foundationLayout)
        implementation(material3)
        implementation(icons)
        implementation(iconsExtended)
    }

    with(Deps.ComposeDestinations) {
        implementation(core)
        ksp(kspPlugin)
    }

    with(Deps.Google) {
        implementation(material)
    }

    with(Deps.Koin) {
        implementation(core)
        implementation(android)
        implementation(compose)
    }

    with(Deps.Ktor) {
        implementation(clientAndroid)
    }

    with(Deps.Mapbox) {
        implementation(core)
    }

    with(Deps.Settings) {
        implementation(noArgs)
    }
}