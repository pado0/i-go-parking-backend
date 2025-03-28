plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "backend-boilerplate"

include("domain")
include("web-api")

include("adapter-in:web-adapter-in")
findProject(":adapter-in:web-adapter-in")?.name = "web-adapter-in"

include("adapter-out:rds-adapter-out")
findProject(":adapter-out:rds-adapter-out")?.name = "rds-adapter-out"

include("port-in:usecase-api-port-in")
findProject(":port-in:usecase-api-port-in")?.name = "usecase-api-port-in"

include("port-out:persistence-port-out")
findProject(":port-out:persistence-port-out")?.name = "persistence-port-out"

include("application:usecase-api")
findProject(":application:usecase-api")?.name = "usecase-api"
