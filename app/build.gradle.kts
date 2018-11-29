plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android.extensions")
    kotlin("android")

}

android {
    compileSdkVersion(deps.android.build.compilesdkversion)
    defaultConfig {
        applicationId  = "com.android.mayojava.dailyfootball"
        minSdkVersion(deps.android.build.minsdkversion)
        targetSdkVersion(deps.android.build.targetsdkversion)
        versionCode  = 1
        versionName  = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables.useSupportLibrary = true
        buildConfigField("String", "NEWS_API_KEY", "6a584a8e430e4e9e813f85b977d3c6b2")
        buildConfigField("String", "FOOTBALL_DATA_TOKEN", "562dcf6e8b3f493186d1c47fc84e3404")
    }
    buildTypes {
        getByName("debug") {

        }

        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":base"))
    implementation(project(":data"))
    implementation(project(":dataandroid"))

    implementation(deps.kotlin.stdlib.jdk8)
    implementation(deps.android.google.material)
    implementation(deps.android.androidx.appcompat)
    implementation(deps.android.androidx.corektx)
    implementation(deps.android.androidx.constraintLayout)
    implementation(deps.android.arch.navigation.fragment)
    implementation(deps.android.arch.navigation.ui)

    testImplementation(deps.test.junit)

    androidTestImplementation(deps.test.espresso.core)
    androidTestImplementation(deps.test.runner)
}
