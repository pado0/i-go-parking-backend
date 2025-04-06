plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "igoparking"

include("domain")
include("mcp-server")
include("mcp-client")

include("adapter-in:common-adapter-in")
findProject(":adapter-in:common-adapter-in")?.name = "common-adapter-in"

include("adapter-in:mcp-client-adapter-in")
findProject(":adapter-in:mcp-client-adapter-in")?.name = "mcp-client-adapter-in"

include("adapter-in:mcp-server-adapter-in")
findProject(":adapter-in:mcp-server-adapter-in")?.name = "mcp-server-adapter-in"

include("adapter-out:rds-adapter-out")
findProject(":adapter-out:rds-adapter-out")?.name = "rds-adapter-out"

include("adapter-out:mcp-adapter-out")
findProject(":adapter-out:mcp-adapter-out")?.name = "mcp-adapter-out"

include("adapter-out:feign-adapter-out")
findProject(":adapter-out:feign-adapter-out")?.name = "feign-adapter-out"

include("port-in:usecase-api-port-in")
findProject(":port-in:usecase-api-port-in")?.name = "usecase-api-port-in"

include("port-out:mcp-port-out")
findProject(":port-out:mcp-port-out")?.name = "mcp-port-out"

include("port-out:persistence-port-out")
findProject(":port-out:persistence-port-out")?.name = "persistence-port-out"

include("application:usecase-api")
findProject(":application:usecase-api")?.name = "usecase-api"
