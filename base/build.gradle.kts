plugins {
    kotlin("jvm")
}

dependencies {
    implementation(deps.kotlin.stdlib.jdk8)
    implementation(deps.jetbrains.coroutines.coroutines_core)
    implementation(deps.jetbrains.coroutines.coroutines_rx)

    implementation(deps.dagger.runtime)

    implementation(deps.square.okhttpLogger)
    implementation(deps.square.retrofit)
}