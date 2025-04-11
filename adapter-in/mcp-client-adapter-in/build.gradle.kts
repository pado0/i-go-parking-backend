repositories {
    maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
    implementation(project(":application:usecase-api"))
    implementation(project(":port-in:usecase-api-port-in"))
    implementation(project(":domain"))

    implementation("org.springframework.ai:spring-ai-mcp-client-webflux-spring-boot-starter:1.0.0-M6")
    implementation(platform("org.springframework.ai:spring-ai-bom:1.0.0-M6"))

    implementation("org.springframework.ai:spring-ai-openai-spring-boot-starter")

    implementation("org.springframework.boot:spring-boot-starter-actuator")
}
