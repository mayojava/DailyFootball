object deps {
    object versions {
        const val kotlinVersion = "1.3.0"
        const val gradlePluginVersion = "3.3.0-beta04"
    }

    object android {
        const val gradlePlugin = "com.android.tools.build:gradle:${versions.gradlePluginVersion}"
    }

    object kotlin {
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${versions.kotlinVersion}"
    }

    object detekt {
        const val plugin = "io.gitlab.arturbosch.detekt"
    }
}