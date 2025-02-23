import org.springframework.boot.gradle.tasks.bundling.BootJar

val bootJar: BootJar by tasks
bootJar.enabled = false

// plugins 블록은 최상위 루트 프로젝트에만 적용되어,
// subproject에는 별도로 정의해야한다.
plugins {
  id("io.spring.dependency-management") version "1.1.6" // 의존성 버전을 명시하지 않아도 자동으로 관리
  id("org.springframework.boot") version "3.3.5" // 실행가능한 jar 파일 생성, tomcat등 자동 설정, gradleTask 활성화

  kotlin("kapt") version "1.9.25" // java와 kotlin annotation processor가 달라 추가
  kotlin("jvm") version "1.9.25" // 코틀린 소스를 컴파일하고 java 바이트코드로 변환, 코틀린 테스트 지원.

  kotlin("plugin.spring") version "1.9.25" // open keyword 없이 상속을 가능하도록 함 (all open, noarg)
  kotlin("plugin.jpa") version "1.9.25"
}

group = "com.leanmysuru"
version = "0.0.1-SNAPSHOT"

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}



allprojects {
  // 디폴트로 bootJar false 해두고, true가 필요한 곳에만 true 설정하기
  tasks.withType<BootJar> {
    enabled = false
  }

  repositories { // 의존성 라이브러리를 메이븐에서 가져온다고 명시
    mavenCentral()
  }
}

subprojects {
  apply {
    plugin("io.spring.dependency-management")
    plugin("org.springframework.boot")
    plugin("org.jetbrains.kotlin.kapt")
    plugin("org.jetbrains.kotlin.jvm")
    plugin("org.jetbrains.kotlin.plugin.spring")
    plugin("org.jetbrains.kotlin.plugin.jpa")
  }
  dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
  }
}


kotlin {
  compilerOptions {
    freeCompilerArgs.addAll("-Xjsr305=strict")
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}

