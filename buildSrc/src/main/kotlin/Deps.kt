object Deps {
    object Accompanist {
        const val navigationAnimation =
            "com.google.accompanist:accompanist-navigation-animation:${Versions.accompanist}"
        const val navigationMaterial =
            "com.google.accompanist:accompanist-navigation-material:${Versions.accompanist}"
        const val systemUiController =
            "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"
        const val insets = "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
    }

    object Android {
        const val material = "com.google.android.material:material:${Versions.material}"
    }

    object AndroidX {
        const val lifecycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"
        const val lifecycleViewmodelKtx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewmodelKtx}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val splashScreen = "androidx.core:core-splashscreen:1.0.0-alpha02"
    }

    object Camera {
        const val camera2 = "androidx.camera:camera-camera2:${Versions.camera}"
        const val video = "androidx.camera:camera-video:1.1.0-alpha12"
    }

    object Compose {
        const val compiler = "androidx.compose.compiler:compiler:${Versions.composeCompiler}"
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val uiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val foundationLayout =
            "androidx.compose.foundation:foundation-layout:${Versions.compose}"
        const val material3 = "androidx.compose.material3:material3:${Versions.material3}"
        const val navigation = "androidx.navigation:navigation-compose:${Versions.navCompose}"
        const val icons = "androidx.compose.material:material-icons-core:${Versions.compose}"
        const val iconsExtended =
            "androidx.compose.material:material-icons-extended:${Versions.compose}"
    }

    object Google {
        const val material = "com.google.android.material:material:${Versions.material}"
    }

    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val test = "io.insert-koin:koin-test:${Versions.koin}}"
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
        const val compose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
    }

    object Kotlin {
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    }

    object Ktor {
        const val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
        const val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
        const val clientIos = "io.ktor:ktor-client-ios:${Versions.ktor}"
        const val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    }

    object Mapbox {
        const val core = "com.mapbox.maps:android:${Versions.mapbox}"
    }

    object Settings {
        const val core = "com.russhwolf:multiplatform-settings:${Versions.settings}"
        const val noArgs = "com.russhwolf:multiplatform-settings-no-arg:${Versions.settings}"
        const val datastore = "com.russhwolf:multiplatform-settings-datastore:${Versions.settings}"
        const val coroutines =
            "com.russhwolf:multiplatform-settings-coroutines:${Versions.settings}"
    }
}