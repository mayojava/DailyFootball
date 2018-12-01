object Versions {
    const val compileSdk = 28
    const val minSdk = 15
    const val targetSdk = 28

    const val kotlin = "1.3.10"
    const val coreKtx = "1.0.1"
    const val appcompat = "1.0.2"
    const val constraintlayout = "1.1.3"
    const val navigation = "1.0.0-alpha07"
    const val material ="1.0.0"
    const val coroutine = "1.0.1"
    const val arrow = "0.8.1"
    const val dagger = "2.19"
    const val retrofit = "2.5.0"
    const val okHttpLogger  = "3.12.0"
    const val room  = "2.1.0-alpha02"
    const val paging = "2.1.0-beta01"
    const val rxjava = "2.2.3"
    const val rxandroid = "2.1.0"
    const val moshi = "1.8.0"
    const val moshiConverter = "2.5.0"

    const val junit = "4.12"
    const val espressocore = "3.1.0"
    const val runner = "1.1.0"
}

object Deps {
    val kt = object  {
        val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        val coroutine = object {
            val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
            val rx = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
        }
    }

    val android = object {
        val androidx = object {
            val core = "androidx.core:core-ktx:${Versions.coreKtx}"
            val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
            val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
            val room = object  {
                val common = "androidx.room:room-common:${Versions.room}"
                val compiler = "androidx.room:room-compiler:${Versions.room}"
                val runtime = "androidx.room:room-runtime:${Versions.room}"
                val roomrx = "androidx.room:room-rxjava2:${Versions.room}"
            }
            val paging = object {
                val common = "androidx.paging:paging-common-ktx:${Versions.paging}"
                val runtime = "androidx.paging:paging-runtime-ktx:${Versions.paging}"
            }
        }

        val arch  = object  {
            val navigation = object {
                val fragment = "android.arch.navigation:navigation-fragment-ktx:${Versions.navigation}"
                val ui = "android.arch.navigation:navigation-ui-ktx:${Versions.navigation}"
            }
        }

        val material = "com.google.android.material:material:${Versions.material}"
    }

    val dagger = object {
        val runtime  = "com.google.dagger:dagger:${Versions.dagger}"
        val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    }

    val square = object {
        val retrofit  = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        val okhttp = object {
            val logging  = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpLogger}"
        }
    }

    val rx = object {
        val rxjava  = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
        val rxkotlin = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
    }

    val moshi = object {
        val retrofitConverter = "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"
        val runtime = "com.squareup.moshi:moshi:${Versions.moshi }"
        val compiler = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    }

    val test = object {
        val espresso = object {
            val core = "androidx.test.espresso:espresso-core:${Versions.espressocore}"
            val runner = "androidx.test:runner:${Versions.runner}"
        }
        val junit = "junit:junit:${Versions.junit}"
    }

    const val arrow = "io.arrow-kt:arrow-core:${Versions.arrow}"
}
