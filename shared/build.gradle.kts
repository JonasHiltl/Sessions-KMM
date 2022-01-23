import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization") version Versions.kotlin
    id("com.android.library")
    id("com.squareup.sqldelight")
}

version = "1.0"

kotlin {
    android()

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iosTarget("ios") {}

    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosSessions/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        all {
            languageSettings.optIn("kotlin.RequiresOptIn")
        }
        val commonMain by getting {
            dependencies {
                with(Deps.Koin) {
                    api(core)
                }

                with(Deps.Kotlin) {
                    implementation(coroutines)
                }

                with(Deps.Ktor) {
                    implementation(clientCore)
                    implementation(clientLogging)
                    implementation(clientSerialization)
                }

                with(Deps.Settings) {
                    implementation(noArgs)
                }

                with(Deps.SQLDelight) {
                    implementation(runtime)
                    implementation(coroutines)
                }
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val androidMain by getting {
            dependencies {
                with(Deps.Ktor) {
                    implementation(clientAndroid)
                }

                with(Deps.SQLDelight) {
                    implementation(android)
                }
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }

        val iosMain by getting {
            dependsOn(commonMain)
            dependencies {
                with(Deps.Ktor) {
                    implementation(clientIos)
                }

                with(Deps.SQLDelight) {
                    implementation(native)
                }
            }
        }

        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }

        val iosTest by getting
        val iosSimulatorArm64Test by getting {
            dependsOn(iosTest)
        }
    }
}

android {
    compileSdk = Versions.androidCompileSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Versions.androidMinSdk
        targetSdk = Versions.androidTargetSdk
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

sqldelight {
    database("SessionDatabase") {
        packageName = "com.example.sessions.datasource.cache"
        sourceFolders = listOf("sqldelight")
    }
}
