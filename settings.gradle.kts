rootProject.name = "workLearnPractice"

dependencyResolutionManagement {
    versionCatalogs {
        // Каталог для модуля
        create("library") {
            from(files("gradle/library.versions.toml"))
        }
    }
}