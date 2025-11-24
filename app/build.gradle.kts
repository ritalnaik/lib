plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.rital.myexpensetracker"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.rital.myexpensetracker"
        minSdk = 25
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")

    // KAPT configuration
    kapt("androidx.room:room-compiler:$room_version") // 👈 MUST use 'kapt'
    val navigationVersion = "2.7.1"
    val material = "1.2.1"
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.2")// ViewModel support in Compose
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.0")// for viewModelScope
    implementation ("com.google.dagger:hilt-android:2.51.1")
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-compiler:2.51.1")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    // Hilt Integration for Jetpack Compose Navigation
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Other standard dependencies
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0")

    // This MUST be 'ksp', not 'implementation'
//    ksp("androidx.room:room-compiler:$roomVersion")
    implementation (libs.androidx.navigation.compose)
    implementation (libs.material3)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}