plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdkVersion (Versions.compileSdk)


    defaultConfig {
        minSdkVersion (Versions.minSdk)
        targetSdkVersion (Versions.targetSdk)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

}

dependencies {
    implementation (deps.misc.timber)
    testImplementation (deps.test.junit)

    implementation (project(":base"))
}
