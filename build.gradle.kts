plugins {
    id("java") // если корневой проект тоже использует java – оставьте, иначе уберите
    id("io.freefair.lombok") version "9.2.0"
}

// Настройки для корневого проекта (если нужны)
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

group = "org.example"
version = "1.0-SNAPSHOT"

allprojects {
    // Применяем плагины к каждому подпроекту
    apply(plugin = "java")
    apply(plugin = "io.freefair.lombok")

    // Настройки Java (теперь доступны)
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    group = rootProject.group
    version = rootProject.version

    repositories {
        mavenLocal()
        mavenCentral()
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.compilerArgs.add("-encoding")
        options.compilerArgs.add("UTF-8")
    }

    tasks.withType<Test> {
        systemProperty("file.encoding", "UTF-8")
        useJUnitPlatform()
    }

    tasks.withType<JavaExec> {
        systemProperty("file.encoding", "UTF-8")
    }
}


dependencies {
    // Используем version catalog libs
    platform(libs.jUnit.bom)
    testImplementation(libs.jUnit.jupiter)
    implementation(libs.aspectJ)
    implementation(libs.spotbug)
    implementation(libs.reflection)
}