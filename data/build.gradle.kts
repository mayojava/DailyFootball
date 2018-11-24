import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("kapt")
}
dependencies {
    implementation(project(":base"))

    implementation(deps.android.androidx.room.commons)
    implementation(deps.reactivex.rxjava)
    implementation(deps.reactivex.rxkotlin)

    kapt(deps.dagger.compiler)

    implementation(deps.dagger.runtime)
    kapt(deps.moshi.compiler)
    compile(kotlin("stdlib-jdk8"))
}

kapt {
    generateStubs = true
}
repositories {
    mavenCentral()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}