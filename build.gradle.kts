plugins {
    id("java")
    id("io.qameta.allure") version "2.12.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
    implementation("com.codeborne:selenide:7.3.1")
    implementation("io.github.bonigarcia:webdrivermanager:5.8.0")
    testImplementation("org.assertj:assertj-core:3.25.3")
    testImplementation("io.qameta.allure:allure-junit5:2.29.1")
    testImplementation("io.qameta.allure:allure-assertj:2.29.1")
    implementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    implementation("org.aspectj:aspectjweaver:1.9.22")
    implementation("org.jsoup:jsoup:1.17.2")
    testImplementation("io.qameta.allure:allure-junit5:2.29.1")
    implementation("io.qameta.allure:allure-assertj:2.29.1")
}


tasks.test {
    useJUnitPlatform()
}