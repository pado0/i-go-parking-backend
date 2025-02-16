plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "leanmysuru"

include("domain")
include("api-service")

include("adapter-in:security-adapter-in")
findProject(":adapter-in:security-adapter-in")?.name = "security-adapter-in"

include("application:usecase-api-service")
findProject(":application:usecase-api-service")?.name = "usecase-api-service"
