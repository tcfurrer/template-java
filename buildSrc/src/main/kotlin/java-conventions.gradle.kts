plugins {
    java
    `java-test-fixtures`
    id("org.gradlex.extra-java-module-info")
}

java {
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
        vendor = JvmVendorSpec.GRAAL_VM
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs.addAll(listOf("-Xlint:all", "-Xlint:-missing-explicit-ctor", "-Werror"))
}

// Centralized Test configuration: enable JUnit Platform for all Java projects
tasks.withType<Test>().configureEach {
    // Use JUnit Platform (so individual subprojects don't have to call useJUnitPlatform())
    useJUnitPlatform()
    // Force tests to always run, never consider them "up to date"
    outputs.upToDateWhen { false }
}
