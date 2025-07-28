plugins {
    id("java")
    id("io.qameta.allure") version "2.12.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    implementation("com.codeborne:selenide:7.2.1")
    implementation("io.github.bonigarcia:webdrivermanager:5.7.0")
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("io.qameta.allure:allure-junit5:2.29.1")
    testImplementation("io.qameta.allure:allure-assertj:2.29.1")
    implementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
}

tasks.test {
    useJUnitPlatform()
}