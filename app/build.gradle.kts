plugins {
    id("java-conventions")
    id("jpackage-conventions")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:6.0.1")
    testImplementation("org.hamcrest:hamcrest:3.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation(testFixtures(project(":app")))

    testFixturesApi("org.junit.jupiter:junit-jupiter-api:6.0.1")
}

application {
    mainModule = "app"
    mainClass = "app.AppMain"
    applicationDefaultJvmArgs = listOf(
        "-Xmx1g",
        "-Djava.security.manager=disallow",
        "-Dfile.encoding=UTF-8"
    )
}
