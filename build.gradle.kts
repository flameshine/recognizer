group = "com.flameshine"
version = "1.0-SNAPSHOT"

description = "Implementation of a simple web application that recognizes text from a user-uploaded file"

plugins {
    java
    id("org.springframework.boot") version "2.6.6"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

val springBootVersion = "2.6.6"
val lombokVersion = "1.18.22"

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:$springBootVersion")
    implementation("net.sourceforge.tess4j:tess4j:5.1.0")

    compileOnly("org.projectlombok:lombok:$lombokVersion")

    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
}
