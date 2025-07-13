plugins {
    kotlin("jvm") version "2.1.10"
}

group = "com.carrie"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // 基础 API & Engine
    testImplementation(kotlin("test-junit5"))

    // 参数化测试支持
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.2")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}