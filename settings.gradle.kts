dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
            credentials {
                username = System.getenv("JITPACK_USERNAME")
                password = System.getenv("JITPACK_KEY")
            }
        }
    }
}
rootProject.name = "Dantotsu"
include(":app")
