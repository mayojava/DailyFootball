plugins {
    id("java-library")
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    implementation (deps.kotlin.stdlib)
    implementation (deps.android.androidx.room.common)
    implementation (deps.android.androidx.room.coroutine)
    api (deps.android.androidx.paging.common)

    api (deps.moshi.retrofitConverter)
    implementation (deps.moshi.runtime)
    kapt (deps.moshi.compiler)

    kapt (deps.dagger.compiler)
    implementation (project(":base"))


}

repositories {
    mavenCentral()
}