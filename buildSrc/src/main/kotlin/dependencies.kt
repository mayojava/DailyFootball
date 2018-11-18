object deps {
    object versions {
        const val kotlinVersion = "1.3.10"
        const val gradlePluginVersion = "3.3.0-beta04"

        const val constraintLayout = "1.1.3"
        const val navigation = "1.0.0-alpha07"
        const val corekts = "1.0.1"
        const val material = "1.0.0"
        const val appcompat = "1.0.2"

        const val retrofit = "2.4.0"
        const val okHttp = "3.12.0"
        const val coroutines = "1.0.1"
        const val dagger = "2.18"
        const val moshi = "1.7.0"

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
    }

    object square {
        const val okhttp = "com.squareup.okhttp3:okhttp:${versions.okHttp}"
        const val okhttpLogger = "com.squareup.okhttp3:logging-interceptor:${versions.okHttp}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${versions.retrofit}"
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
}