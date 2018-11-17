// Top-level build file where you can add configuration options common to all sub-projects/modules.

import deps

buildscript {
    repositories {
        google()
        jcenter()
        
    }
    dependencies {
        classpath(deps.android.gradlePlugin)
        classpath(deps.kotlin.gradlePlugin)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    id(deps.detekt.plugin) version "1.0.0-RC11"
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
    register("clean", Delete::class.java) {
        delete("$rootProject.buildDir")
    }
}
