import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.roomDb() {
    add("implementation", Libraries.roomDb)
    add("implementation", Libraries.roomGuava)
    add("implementation", Libraries.roomKtx)
    add("kapt", Libraries.roomCompiler)
    add("testImplementation", Libraries.roomTesting)
}

fun DependencyHandler.koin() {
    add("implementation", Libraries.koin)
    add("implementation", Libraries.koinViewModel)
    add("implementation", Libraries.koinTest)
}

fun DependencyHandler.lifecycleLibs() {
    add("kapt", Libraries.lifecycleCommon)
    add("implementation", Libraries.lifecycleExtensions)
    add("implementation", Libraries.lifecycleViewmodel)
}

fun DependencyHandler.navigation() {
    add("implementation", Libraries.navigationFragmentKtx)
    add("implementation", Libraries.navigationFragmentUiKtx)
}

fun DependencyHandler.appCenter() {
    add("implementation", Libraries.appCenterAnalytics)
    add("implementation", Libraries.appCenterCrashes)
    add("implementation", Libraries.appCenterPush)
}

fun DependencyHandler.retrofit(configurationType: configurationType) {
    add(configurationType.toString(), Libraries.retrofit)
    add(configurationType.toString(), Libraries.retrofitConverterGson)
}

fun DependencyHandler.firebase(configurationType: configurationType) {
    add("implementation", "com.google.firebase:firebase-core:17.2.3")
    add("implementation", "com.google.firebase:firebase-messaging:20.1.2")
    add("implementation", "com.google.firebase:firebase-storage:19.1.1")
    add("implementation", "com.google.firebase:firebase-ml-vision:24.0.1")
}

enum class configurationType {
    implementation, api
}