repositories {
    maven { url = uri("https://repo.spring.io/milestone") } // Spring AI는 아직 마일스톤 버전이므로 해당 저장소 추가
}

dependencies {
    implementation(project(":port-in:usecase-api-port-in"))

    implementation("org.springframework.ai:spring-ai-mcp-server-spring-boot-starter:1.0.0-M6") // MCP 서버 스타터
    implementation("org.springframework.ai:spring-ai-mcp-server-webmvc-spring-boot-starter:1.0.0-M6") // MCP 서버 스타터
    implementation("org.springframework.ai:spring-ai-bom:1.0.0-M6") // OpenAI 연동을 위한 스타터
}
