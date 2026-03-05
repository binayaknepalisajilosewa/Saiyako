package ani.saiyako.connections.crashlytics

class CrashlyticsFactory {
    companion object {
        fun createCrashlytics(): CrashlyticsInterface {
            return FirebaseCrashlytics()
        }
    }
}