object Libraries {
    //RoomDb
    const val roomDb = "androidx.room:room-runtime:${Versions.roomDb}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomDb}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomDb}"
    const val roomGuava = "androidx.room:room-guava:${Versions.roomDb}"
    const val roomTesting = "androidx.room:room-testing:${Versions.roomDb}"

    //Koin
    const val koin = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val koinTest = "org.koin:koin-test:${Versions.koin}"

    //ViewPager
    const val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.viewPager2}"

    //TimeLine
    const val timeLine = "com.github.vipulasri:timelineview:${Versions.timeLine}"

    //LifeCycle
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleViewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"

    //Navigation
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationFragmentUiKtx =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    const val jodaTime = "joda-time:joda-time:${Versions.jodaTime}"

    //AppCenter
    const val appCenterAnalytics =
        "com.microsoft.appcenter:appcenter-analytics:${Versions.appCenterSdkVersion}"
    const val appCenterCrashes =
        "com.microsoft.appcenter:appcenter-crashes:${Versions.appCenterSdkVersion}"
    const val appCenterPush =
        "com.microsoft.appcenter:appcenter-push:${Versions.appCenterSdkVersion}"

    //Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    //Guava
    const val guava = "com.google.guava:guava:${Versions.guava}"

    //Data binding validator
    const val dataBindingValidator =
        "com.github.Ilhasoft:data-binding-validator:${Versions.dataBindingValidator}"

}

object Versions {
    const val dataBindingValidator = "2.0.0"
    const val roomDb = "2.2.3"
    const val koin = "2.0.1"
    const val viewPager2 = "1.0.0"
    const val timeLine = "1.1.0"
    const val lifecycle = "2.2.0"
    const val navigation = "2.2.1"
    const val jodaTime = "2.10"
    const val appCenterSdkVersion = "2.4.1"
    const val retrofit = "2.7.1"
    const val guava = "28.2-jre"
    const val kotlinVersion = "1.3.70"
    const val buildToolsVersion = "3.6.1"
}

object BuildPlugins {

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"

}

object AndroidSdk {
    const val min = 21
    const val compile = 29
    const val target = compile
}