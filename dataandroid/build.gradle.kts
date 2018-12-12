plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion (Versions.compileSdk)

    defaultConfig {
        minSdkVersion (Versions.minSdk)
        targetSdkVersion (Versions.targetSdk)
        versionCode  = 1
        versionName  = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

}

kapt {
    arguments {
        arg("room.schemaLocation", "$projectDir/schemas".toString())
    }
}

dependencies {
    implementation (deps.android.androidx.room.runtime)
    implementation (deps.android.androidx.room.roomrx)
    implementation (deps.android.androidx.room.coroutine)

    kapt (deps.android.androidx.room.compiler)

    implementation (deps.android.androidx.paging.runtime)

    kapt (deps.dagger.compiler)

    testImplementation (deps.test.junit)
    testImplementation (deps.test.truth)

    androidTestImplementation (deps.android.androidx.room.test)
    androidTestImplementation (deps.test.junit)
    androidTestImplementation (deps.test.support.runner)
    androidTestImplementation (deps.test.support.ext)
    androidTestImplementation (deps.test.support.rules)
    androidTestImplementation (deps.test.truth)
    androidTestImplementation (deps.android.androidx.lifecycle.test)

    implementation (project(":baseandroid"))
    implementation (project(":data"))
    implementation (project(":base"))
}