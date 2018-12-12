plugins {
    id("kotlin")
    id("java-library")
}

dependencies {
    implementation (project(":base"))
    implementation (project(":data"))
}