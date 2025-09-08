plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")
}

android {
    namespace = "com.certicode.inventiapp"
    compileSdk = 36

    buildFeatures {
        viewBinding = true
    }
    buildFeatures {
        dataBinding = false
    }

    defaultConfig {
        applicationId = "com.certicode.inventiapp"
        minSdk = 33
        targetSdk = 36
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.fragment)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.coil.svg)
//    implementation ("com.github.sung2063:AndroidSliderViewsLibrary:1.8")
    implementation (libs.material.v110)
    implementation (libs.library)
    implementation (libs.androidx.recyclerview)
    implementation("com.google.android.flexbox:flexbox:3.0.0")

    //viewpager
    implementation(libs.viewpager2)
    implementation (libs.material) // Or newer version

    //Google Maps
    implementation("com.google.android.gms:play-services-maps:18.2.0")


    //Splash Screen
    implementation("androidx.core:core-splashscreen:1.0.1")

    

    implementation("de.hdodenhof:circleimageview:3.1.0")


}