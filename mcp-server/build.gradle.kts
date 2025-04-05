dependencies {
    implementation(project(":adapter-out:rds-adapter-out"))
    implementation(project(":adapter-out:mcp-adapter-out"))
    implementation(project(":adapter-in:mcp-server-adapter-in"))
    implementation(project(":application:usecase-api"))
    implementation(project(":domain"))
    implementation("org.springframework.boot:spring-boot-starter-actuator")
}

tasks {
    bootJar {
        enabled = true
        archiveFileName.set("boot.jar")
    }
}
