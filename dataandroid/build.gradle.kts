plugins {
    id("com.android.library")
    kotlin("kapt")
    kotlin("android")
}

android {
    compileSdkVersion(deps.android.build.compilesdkversion)

    defaultConfig {
        minSdkVersion(deps.android.build.minsdkversion)
        targetSdkVersion(deps.android.build.targetsdkversion)
        versionCode  = 1
        versionName  = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

}

dependencies {
    implementation(project(":base"))
    implementation(project(":data"))

    implementation(deps.android.androidx.room.runtime)
    implementation(deps.android.androidx.room.rxjava)
    kapt(deps.android.androidx.room.compiler)

    implementation(deps.android.androidx.paging.runtime)

    kapt(deps.dagger.compiler)

    testImplementation(deps.test.junit)
}