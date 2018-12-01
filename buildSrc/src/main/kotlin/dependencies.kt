object deps {
    object versions {
        const val kotlinVersion = "1.3.10"
        const val gradlePluginVersion = "3.4.0-alpha06"

        const val constraintLayout = "1.1.3"
        const val navigation = "1.0.0-alpha07"
        const val room = "2.1.0-alpha02"
        const val paging = "2.1.0-beta01"
        const val corekts = "1.0.1"
        const val material = "1.0.0"
        const val appcompat = "1.0.2"

        const val retrofit = "2.5.0"
        const val okHttp = "3.12.0"
        const val coroutines = "1.0.1"
        const val dagger = "2.19"
        const val moshi = "1.8.0"
        const val rxjava = "2.2.3"
        const val rxkotlin = "2.1.0"
        const val arrow = "0.8.1"
        const val inboxrecycler = "1.0.0-rc1"
        const val glide = "4.8.0"

        const val junit = "4.12"
        const val runner = "1.1.0"
        const val espressocore = "3.1.0"
    }

    object android {
        const val gradlePlugin = "com.android.tools.build:gradle:${versions.gradlePluginVersion}"

        object build {
            const val compilesdkversion = 28
            const val minsdkversion = 15
            const val targetsdkversion = 28
        }

        object arch {
            object navigation {
                const val fragment = "android.arch.navigation:navigation-fragment-ktx:${versions.navigation}"
                const val ui = "android.arch.navigation:navigation-ui-ktx:${versions.navigation}"
            }
        }

        object androidx {
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:${versions.constraintLayout}"
            const val appcompat = "androidx.appcompat:appcompat:${versions.appcompat}"
            const val corektx = "androidx.core:core-ktx:${versions.corekts}"
            object room {
                const val runtime = "androidx.room:room-runtime:${versions.room}"
                const val compiler = "androidx.room:room-compiler:${versions.room}"
                const val rxjava = "androidx.room:room-rxjava2:${versions.room}"
                const val commons = "androidx.room:room-common:${versions.room}"
                const val testing = "androidx.room:room-testing:${versions.room}"
            }
            object paging {
                const val common = "androidx.paging:paging-common-ktx:${versions.paging}"
                const val runtime = "androidx.paging:paging-runtime-ktx:${versions.paging}"
            }
        }

        object google {
            const val material = "com.google.android.material:material:${versions.material}"
        }
    }

    object kotlin {
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${versions.kotlinVersion}"

        object stdlib {
            const val core = "org.jetbrains.kotlin:kotlin-stdlib:${versions.kotlinVersion}"
            const val jdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${versions.kotlinVersion}"
            const val jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${versions.kotlinVersion}"
        }
    }

    object jetbrains {
        object coroutines {
            const val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${versions.coroutines}"
            const val coroutines_rx = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${versions.coroutines}"
        }
    }

    object detekt {
        const val plugin = "io.gitlab.arturbosch.detekt"
    }

    object dagger {
        const val runtime = "com.google.dagger:dagger:${versions.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${versions.dagger}"
    }

    object square {
        const val okhttp = "com.squareup.okhttp3:okhttp:${versions.okHttp}"
        const val okhttpLogger = "com.squareup.okhttp3:logging-interceptor:${versions.okHttp}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${versions.retrofit}"
        const val moshi_converter = "com.squareup.retrofit2:converter-moshi:${versions.retrofit}"
    }

    object test {
        const val junit = "junit:junit:${versions.junit}"
        const val runner = "androidx.test:runner:${versions.runner}"
        object espresso {
            const val core = "androidx.test.espresso:espresso-core:${versions.espressocore}"
        }
    }

    object moshi {
        const val core = "com.squareup.moshi:moshi:${versions.moshi}"
        const val compiler = "com.squareup.moshi:moshi-kotlin-codegen:${versions.moshi}"
    }

    object reactivex {
        const val rxjava = "io.reactivex.rxjava2:rxjava:${versions.rxjava}"
        const val rxkotlin = "io.reactivex.rxjava2:rxandroid:${versions.rxkotlin}"
    }

    object arrow {
        const val core = "io.arrow-kt:arrow-core:${versions.arrow}"
    }

    object misc {
        const val inboxrecyclerview = "me.saket:inboxrecyclerview:${versions.inboxrecycler}"
        object glide {
            const val glide = "com.github.bumptech.glide:glide:${versions.glide}"
            const val processor = "com.github.bumptech.glide:compiler:${versions.glide}"
        }
    }
}