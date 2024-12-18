plugins {
    id("com.android.application") version "8.1.2" apply true
    id("org.jetbrains.kotlin.android") version "1.9.10" apply true
    id("com.google.devtools.ksp") version "1.9.10-1.0.13"
    id("com.google.dagger.hilt.android") version "2.50"
}

android {
    namespace = "com.example.inventorymanager"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.inventorymanager"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("com.google.dagger:hilt-android:2.50")
    ksp("com.google.dagger:hilt-compiler:2.50")
}
