rootProject.name = "workLearnPractice"

include("functionalInterface_practice")
include("OOP_practice")
include("testNG_practice")

dependencyResolutionManagement {
    versionCatalogs {
        // Каталог для модуля
        create("libs") {
            from(files("gradle/library.versions.toml"))
        }
    }
}

