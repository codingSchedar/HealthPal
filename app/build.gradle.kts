plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.healthpalapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.healthpalapp"
        minSdk = 28
        targetSdk = 34
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


    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.monitor)
    implementation(libs.ext.junit)
    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.testng)
}