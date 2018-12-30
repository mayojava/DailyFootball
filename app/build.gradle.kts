plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("androidx.navigation.safeargs")
    id("kotlin-kapt")

}

android {
    compileSdkVersion (Versions.compileSdk)
    defaultConfig {
        applicationId  = "com.android.mayojava.dailyfootball"
        minSdkVersion (Versions.minSdk)
        targetSdkVersion (Versions.targetSdk)
        versionCode  = 1
        versionName  = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables.useSupportLibrary = true
        buildConfigField("String", "NEWS_API_KEY", "\"6a584a8e430e4e9e813f85b977d3c6b2\"")
        buildConfigField("String", "FOOTBALL_DATA_TOKEN", "\"562dcf6e8b3f493186d1c47fc84e3404\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    lintOptions {
        isAbortOnError = true
    }
}

kapt {
    useBuildCache = true
    arguments {
        correctErrorTypes = true
        arg("moshi.generated", "javax.annotation.Generated")
        arg("dagger.formatGeneratedSource", "disabled")
    }
}

dependencies {
    implementation (deps.kotlin.stdlib)
    implementation (deps.android.material)
    implementation (deps.android.androidx.appcompat)
    implementation (deps.android.androidx.core)
    implementation (deps.android.androidx.constraintlayout)
    implementation (deps.android.arch.navigation.fragment)
    implementation (deps.android.arch.navigation.ui)

    implementation (deps.android.androidx.lifecycle.extensions)
    implementation (deps.android.androidx.lifecycle.rx)
    kapt (deps.android.androidx.lifecycle.compiler)
    
    implementation (deps.dagger.android.runtime)
    implementation (deps.dagger.android.support_runtime)
    kapt (deps.dagger.compiler)
    kapt (deps.dagger.android.processor)

    implementation (deps.android.androidx.workManager.runtime)

    implementation(deps.kotlin.coroutine.android)

    implementation (deps.misc.glide.runtime)
    kapt (deps.misc.glide.processor)

    implementation (deps.android.customtab)

    testImplementation (deps.test.junit)
    testImplementation (deps.android.androidx.lifecycle.test)
    testImplementation (deps.android.androidx.room.test)
    testImplementation (deps.android.androidx.workManager.test)
    testImplementation (deps.test.truth)

    androidTestImplementation (deps.test.espresso.core)
    androidTestImplementation (deps.test.support.runner)
    androidTestImplementation (deps.test.support.ext)
    androidTestImplementation (deps.test.truth)

    implementation (project(":interactor"))
    implementation (project(":base"))
    implementation (project(":data"))
    implementation (project(":dataandroid"))
    implementation (project(":baseandroid"))
}
