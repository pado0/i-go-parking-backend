dependencies {
    implementation(project(":adapter-in:mcp-client-adapter-in"))
    implementation(project(":domain"))
}

tasks {
    bootJar {
        enabled = true
        archiveFileName.set("boot.jar")
    }
}
