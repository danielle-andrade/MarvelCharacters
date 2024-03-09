plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
        kotlin("plugin.serialization") version "1.9.21"

}

android {
    namespace = "com.example.marvelcharacters"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.marvelcharacters"
        minSdk = 32
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/LICENSE.md"
            excludes += "/META-INF/LICENSE-notice.md"
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("com.squareup.retrofit2:adapter-guava:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.12")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    implementation("com.jakewharton.retrofit:retrofit1-okhttp3-client:1.1.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.6")
    implementation("androidx.navigation:navigation-compose:2.7.6")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("org.kodein.di:kodein-di-framework-android-x-viewmodel-savedstate:7.21.2")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("org.kodein.di:kodein-di-framework-compose:7.21.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("cafe.adriel.voyager:voyager-navigator:1.1.0-alpha02")
    implementation("cafe.adriel.voyager:voyager-screenmodel:1.1.0-alpha02")
    implementation("cafe.adriel.voyager:voyager-transitions:1.1.0-alpha02")
    implementation("cafe.adriel.voyager:voyager-kodein:1.1.0-alpha02")
    implementation("io.coil-kt:coil-compose:2.5.0")
    implementation("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation("androidx.paging:paging-compose:3.2.1")
    implementation("io.mockk:mockk:1.13.9")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0")
    implementation("androidx.paging:paging-compose:3.2.1")
    implementation("androidx.paging:paging-runtime:3.2.1")
    implementation("com.google.accompanist:accompanist-swiperefresh:0.35.0-alpha")
    implementation("androidx.compose.ui:ui-test-junit4:1.6.2")
    implementation("androidx.compose.ui:ui-test-manifest:1.6.2")
    implementation("androidx.compose.material3:material3:1.3.0-alpha01")
    implementation("androidx.compose.ui:ui-text:1.6.2")
    implementation("androidx.paging:paging-compose:3.3.0-alpha03")
    implementation("androidx.lifecycle:lifecycle-common:2.7.0")
    implementation("io.github.kevinnzou:compose-paginglist:1.1.0")
    implementation("app.cash.paparazzi:app.cash.paparazzi.gradle.plugin:1.3.3")
    implementation("app.cash.paparazzi:paparazzi:1.3.3")
    implementation("com.google.testparameterinjector:test-parameter-injector:1.15")
    testImplementation("org.testng:testng:6.9.6")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}