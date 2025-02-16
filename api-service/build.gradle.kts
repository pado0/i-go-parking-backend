

dependencies {
    implementation(project(":application:usecase-api-service"))
}


tasks {
    bootJar {
        enabled = true
        archiveFileName.set("boot.jar")
    }
}
