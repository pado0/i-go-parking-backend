repositories {
    maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
    implementation(project(":port-in:usecase-api-port-in"))
    implementation(project(":port-out:mcp-port-out"))
    implementation(project(":domain"))

    implementation("org.springframework.ai:spring-ai-mcp-server-webmvc-spring-boot-starter:1.0.0-M6")
    implementation("org.springframework.ai:spring-ai-bom:1.0.0-M6")
}
