plugins {
    java
    application
}

group = "com.mixplus"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<JavaExec> {
    standardInput = System.`in`
    jvmArgs = listOf("-Dfile.encoding=UTF-8")
}

application {
    mainClass.set("com.mixplus.Main")
}

tasks.test {
    useJUnitPlatform()
}