// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        
    }
    dependencies {
        classpath (deps.gradle.plugins.androidPlugin)
        classpath (deps.gradle.plugins.safeArgs)
        classpath (deps.gradle.plugins.kotlin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    id ("io.gitlab.arturbosch.detekt") version "1.0.0-RC11"
}

allprojects {
    apply {
        from("$rootDir/detekt.gradle")
    }

    repositories {
        google()
        jcenter()
        
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}
