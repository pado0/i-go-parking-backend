dependencies {
    implementation(project(":adapter-in:web-adapter-in"))
    implementation(project(":adapter-out:rds-adapter-out"))
    implementation(project(":adapter-out:mcp-adapter-out"))
    implementation(project(":domain"))
}

tasks {
    bootJar {
        enabled = true
        archiveFileName.set("boot.jar")
    }
}
