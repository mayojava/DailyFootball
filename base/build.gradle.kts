plugins {
    kotlin("jvm")
}

dependencies {
    api(deps.kotlin.stdlib.jdk8)
    api(deps.jetbrains.coroutines.coroutines_core)
    api(deps.jetbrains.coroutines.coroutines_rx)

    api(deps.dagger.runtime)

    api(deps.square.okhttpLogger)
    api(deps.square.retrofit)

    api(deps.arrow.core)
}