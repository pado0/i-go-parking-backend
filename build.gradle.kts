import org.springframework.boot.gradle.tasks.bundling.BootJar

val bootJar: BootJar by tasks
bootJar.enabled = false

plugins {
  kotlin("jvm") version "1.9.25" // 코들린 소스를 컴파일하고 java 바이트코드로 변환, 코틀린 테스트 지원.
  kotlin("plugin.spring") version "1.9.25" // open keyword 없이 상속을 가능하도록 함 (all open, noarg)
  id("org.springframework.boot") version "3.3.5" // 실행가능한 jar 파일 생성, tomcat등 자동 설정, gradleTask 활성화
  id("io.spring.dependency-management") version "1.1.6" // 의존성 버전을 명시하지 않아도 자동으로 관리
}

group = "com.leanmysuru"
version = "0.0.1-SNAPSHOT"

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
  compilerOptions {
    freeCompilerArgs.addAll("-Xjsr305=strict")
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}

