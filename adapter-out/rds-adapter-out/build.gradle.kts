
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.postgresql:postgresql")
    implementation("org.flywaydb:flyway-database-postgresql")

    implementation(project(":port-out:persistence-port-out"))
    implementation(project(":domain"))
}