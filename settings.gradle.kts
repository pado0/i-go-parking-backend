plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "leanmysuru"

include("domain")
include("api-service")

include("core:security-core")
findProject(":core:security-core")?.name = "security-core"

