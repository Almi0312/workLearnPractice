dependencies {
    // Используем version catalog libs
    testImplementation(libs.testng)
    implementation(libs.aspectJ)
    implementation(libs.spotbug)
    implementation(libs.reflection)
}

tasks.test {
    testLogging {
        showStandardStreams = true
    }
    useTestNG {
        suites("src/test/resources/testng.xml")  // путь к твоему XML
    }
}