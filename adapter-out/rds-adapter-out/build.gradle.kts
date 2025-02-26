
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.postgresql:postgresql")

    implementation(project(":port-out:persistence-port-out"))
    implementation(project(":domain"))
}