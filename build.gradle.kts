plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

// 1. Для всех задач компиляции Java
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-encoding")
    options.compilerArgs.add("UTF-8")
}

// 2. Для всех задач, запускающих тесты (JUnit, TestNG)
tasks.withType<Test> {
    systemProperty("file.encoding", "UTF-8")
}

// 3. Для всех задач запуска приложения (JavaExec)
tasks.withType<JavaExec> {
    systemProperty("file.encoding", "UTF-8")
}

dependencies {
    testImplementation(platform(libs.jUnit.bom))
    testImplementation(libs.jUnit.jupiter)

//    stat analyze
    implementation(libs.spotbug)
}

tasks.test {
    useJUnitPlatform()
}