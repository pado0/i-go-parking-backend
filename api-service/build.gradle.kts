dependencies {
    /**
     *  this module is only for bean injection.
     *  so there is no way to use adapter method.
     *  we can implement it
     */
    implementation(project(":adapter-in:web-adapter-in"))
    implementation(project(":adapter-in:security-adapter-in"))
    implementation(project(":adapter-out:rds-adapter-out"))
    implementation(project(":domain"))
}


tasks {
    bootJar {
        enabled = true
        archiveFileName.set("boot.jar")
    }
}
