rootProject.name = "workLearnPractice"

include("glava7")

dependencyResolutionManagement {
    versionCatalogs {
        // Каталог для модуля
        create("libs") {
            from(files("gradle/library.versions.toml"))
        }
    }
}