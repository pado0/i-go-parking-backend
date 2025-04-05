repositories {
    maven { url = uri("https://repo.spring.io/milestone") } // Spring AI는 아직 마일스톤 버전이므로 해당 저장소 추가
}

dependencies {
    implementation(project(":application:usecase-api"))
//    implementation(project(":adapter-in:common-adapter-in"))
    implementation(project(":port-in:usecase-api-port-in"))
    implementation(project(":domain"))

    implementation("org.springframework.ai:spring-ai-mcp-client-webflux-spring-boot-starter:1.0.0-M6")
    implementation(platform("org.springframework.ai:spring-ai-bom:1.0.0-M6"))

    implementation("org.springframework.ai:spring-ai-openai-spring-boot-starter")

    implementation("org.springframework.boot:spring-boot-starter-actuator")
}
