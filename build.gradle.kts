

plugins {
    java
    application
}

group = "com.mixplus"
version = "1.0"

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/mixplus-main/config-api")
        credentials {
            username = System.getenv("GITHUB_USERNAME")
            password = System.getenv("GITHUB_TOKEN")
        }
    }
}


dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.mixplus:config-api:1.1-SNAPSHOT")
}

tasks.withType<JavaExec> {
    standardInput = System.`in`
    jvmArgs = listOf("-Dfile.encoding=UTF-8")
}

application {
    mainClass.set("com.mixplus.Main")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.mixplus.Main"
    }
}

tasks.test {
    useJUnitPlatform()
}