import java.nio.file.Files

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention").version("1.0.0")
}

rootProject.name = "template-java"

rootDir.listFiles()?.forEach { dir ->
    if (Files.isDirectory(dir.toPath())
            && Files.exists(dir.toPath().resolve("build.gradle.kts"))
            && !listOf("buildSrc").contains(dir.name)) {
        include(dir.name)
    }
}
