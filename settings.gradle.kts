plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "leanmysuru"

include("domain")
include("api-service")

include("adapter-in:web-adapter-in")
findProject(":adapter-in:web-adapter-in")?.name = "web-adapter-in"

include("adapter-in:security-adapter-in")
findProject(":adapter-in:security-adapter-in")?.name = "security-adapter-in"

include("adapter-out:rds-adapter-out")
findProject(":adapter-out:rds-adapter-out")?.name = "rds-adapter-out"

include("port-out:persistence-port-out")
findProject(":port-out:persistence-port-out")?.name = "persistence-port-out"

include("application:usecase-api-service")
findProject(":application:usecase-api-service")?.name = "usecase-api-service"
