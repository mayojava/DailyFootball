plugins {
    id("java-library")
    id("kotlin")
}

dependencies {
    api (deps.kotlin.stdlib)

    api (deps.kotlin.coroutine.core)
    api (deps.kotlin.coroutine.rx)

    api (deps.dagger.runtime)

    api (deps.square.okhttp.logging)
    api (deps.square.retrofit)

    api (deps.arrow)
    api (deps.rx.rxjava)
    api (deps.rx.rxkotlin)
}
