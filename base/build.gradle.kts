plugins {
    kotlin("jvm")
    kotlin("kapt")
}

dependencies {
    api(deps.kotlin.stdlib.jdk8)
    api(deps.jetbrains.coroutines.coroutines_core)
    api(deps.jetbrains.coroutines.coroutines_rx)

    api(deps.dagger.runtime)

    api(deps.square.okhttpLogger)
    api(deps.square.retrofit)

    api(deps.arrow.core)

    api(deps.moshi.core)
    api(deps.square.moshi_converter)
    kapt(deps.moshi.compiler)
}