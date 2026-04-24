dependencies {
    // Используем version catalog libs
    platform(libs.jUnit.bom)
    testImplementation(libs.jUnit.jupiter)
    implementation(libs.aspectJ)
    implementation(libs.spotbug)
    implementation(libs.reflection)
}