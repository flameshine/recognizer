group = "com.flameshine"
version = "1.0-SNAPSHOT"

description = "To be added..."

plugins {
    java
    id("org.springframework.boot") version "2.6.2"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

val springBootVersion = "2.6.2"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:${springBootVersion}")
    implementation("net.sourceforge.tess4j:tess4j:5.0.0")
}

tasks.test {
    useJUnitPlatform()
}