import org.gradle.api.JavaVersion.VERSION_21

plugins {
    java
}

group = "de.ole101.aoc"
version = "1.0.0"
description = "My solutions for advent of code 2024"

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://jitpack.io")
}

dependencies {
    implementation("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")
    implementation("org.jetbrains:annotations:26.0.1")
}

tasks {
    withType<JavaCompile>().configureEach {
        sourceCompatibility = VERSION_21.toString()
        targetCompatibility = VERSION_21.toString()
        options.encoding = "UTF-8"
    }

    named<Jar>("jar") {
        archiveFileName.set("${rootProject.name}-${project.version}.jar")
    }
}
