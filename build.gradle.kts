plugins {
    id("java")
    id("io.freefair.lombok") version "9.2.0"

}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
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
    platform(libs.jUnit.bom)
    testImplementation(libs.jUnit.jupiter)
    implementation(libs.aspectJ)
//    stat analyze
    implementation(libs.spotbug)
}

tasks.test {
    useJUnitPlatform()
}