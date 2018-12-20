object Versions {
    const val compileSdk = 28
    const val minSdk = 15
    const val targetSdk = 28

    const val kotlin = "1.3.11"
    const val coreKtx = "1.0.1"
    const val supportVersion = "1.0.2"
    const val constraintlayout = "1.1.3"
    const val navigation = "1.0.0-alpha08"
    const val material ="1.0.0"
    const val coroutine = "1.0.1"
    const val arrow = "0.8.1"
    const val dagger = "2.19"
    const val retrofit = "2.5.0"
    const val okHttpLogger  = "3.12.0"
    const val room  = "2.1.0-alpha03"
    const val workManager = "1.0.0-alpha12"
    const val lifecycle = "2.0.0"
    const val paging = "2.1.0-rc01"
    const val rxjava = "2.2.3"
    const val rxandroid = "2.1.0"
    const val moshi = "1.8.0"
    const val moshiConverter = "2.5.0"
    const val inboxrecycler = "1.0.0-rc1"
    const val glide = "4.8.0"
    const val timber = "4.7.1"
    const val customtab = "28.0.0-alpha1"

    const val androidGradlePlugin = "3.4.0-alpha09"

    const val junit = "4.12"
    const val espressocore = "3.1.0"
    const val runner = "1.1.0"
    const val truth = "0.42"
}

object deps {
    const val arrow = "io.arrow-kt:arrow-core:${Versions.arrow}"

    object gradle {
        object plugins {
            const val safeArgs = "android.arch.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
            const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
            const val androidPlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
        }
    }

    object android {
        const val material = "com.google.android.material:material:${Versions.material}"
        const val customtab = "com.android.support:customtabs:${Versions.customtab}"
        object androidx {
            const val core = "androidx.core:core-ktx:${Versions.coreKtx}"
            const val appcompat = "androidx.appcompat:appcompat:${Versions.supportVersion}"
            const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
            const val cardview = "androidx.cardview:cardview:${Versions.supportVersion}"
            const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.supportVersion}"

            object room {
                const val common = "androidx.room:room-common:${Versions.room}"
                const val compiler = "androidx.room:room-compiler:${Versions.room}"
                const val runtime = "androidx.room:room-runtime:${Versions.room}"
                const val roomrx = "androidx.room:room-rxjava2:${Versions.room}"
                const val test = "androidx.room:room-testing:${Versions.room}"
                const val coroutine = "androidx.room:room-coroutines:${Versions.room}"
            }

            object paging {
                const val common = "androidx.paging:paging-common-ktx:${Versions.paging}"
                const val runtime = "androidx.paging:paging-runtime-ktx:${Versions.paging}"
            }

            object lifecycle {
                const val extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
                const val rx = "android.arch.lifecycle:reactivestreams:${Versions.lifecycle}"
                const val compiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
                const val common = "androidx.lifecycle:lifecycle-livedata:${Versions.lifecycle}"
                const val test = "androidx.arch.core:core-testing:${Versions.lifecycle}"
            }

            object workManager {
                const val runtime = "android.arch.work:work-runtime-ktx:${Versions.workManager}"
                const val test = "android.arch.work:work-testing:${Versions.workManager}"
            }
        }

        object arch {
            object navigation {
                const val fragment = "android.arch.navigation:navigation-fragment-ktx:${Versions.navigation}"
                const val ui = "android.arch.navigation:navigation-ui-ktx:${Versions.navigation}"
                const val testing = "android.arch.navigation:navigation-testing:${Versions.navigation}"
            }
        }
    }

    object dagger {
        const val runtime  = "com.google.dagger:dagger:${Versions.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
        object android {
            const val runtime = "com.google.dagger:dagger-android:${Versions.dagger}"
            const val support_runtime = "com.google.dagger:dagger-android-support:${Versions.dagger}"
            const val processor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
        }
    }

    object moshi {
        const val retrofitConverter = "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"
        const val runtime = "com.squareup.moshi:moshi:${Versions.moshi }"
        const val compiler = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    }

    object misc {
        const val inboxrecyclerview = "me.saket:inboxrecyclerview:${Versions.inboxrecycler}"
        const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

        object glide {
            const val runtime = "com.github.bumptech.glide:glide:${Versions.glide}"
            const val processor = "com.github.bumptech.glide:compiler:${Versions.glide}"
        }
    }

    object kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        object coroutine {
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
            const val rx = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${Versions.coroutine}"
        }
    }

    object rx {
        const val rxjava  = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
        const val rxkotlin = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
    }

    object square {
        const val retrofit  = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        object okhttp {
            const val logging  = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpLogger}"
        }
    }

    object test {
        const val junit = "junit:junit:${Versions.junit}"
        const val truth = "com.google.truth:truth:${Versions.truth}"

        object espresso {
            const val core = "androidx.test.espresso:espresso-core:${Versions.espressocore}"
        }
        object support {
            const val runner = "androidx.test:runner:${Versions.runner}"
            const val rules = "androidx.test:rules:${Versions.runner}"
            const val ext = "androidx.test.ext:junit:1.0.0"
        }
    }
}