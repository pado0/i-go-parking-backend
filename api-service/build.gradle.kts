plugins {
    kotlin("jvm")
}

group = "com.leanmysuru"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core:security-core"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

tasks {
    bootJar {
        enabled = true
        archiveFileName.set("boot.jar")
    }
}
