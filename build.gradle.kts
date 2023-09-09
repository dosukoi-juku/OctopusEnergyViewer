plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    kotlin("android").version(libs.versions.kotlin).apply(false)
    kotlin("multiplatform").version(libs.versions.kotlin).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
