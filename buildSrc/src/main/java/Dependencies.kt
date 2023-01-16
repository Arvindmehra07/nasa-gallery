object Versions {
    const val kotlin = "1.7.10"
    const val core_ktx = "1.8.0"
    const val compose = "1.2.1"
    const val composeActivity = "1.5.1"
    const val hilt = "2.43.2"
    const val hiltNavigationForCompose = "1.0.0"
    const val retrofit = "2.9.0"
    const val okHttp3 = "5.0.0-alpha.2"
    const val lifecycle = "2.5.1"
    const val accompanist_flowlayout = "0.17.0"
    const val coroutines = "1.6.1"
    const val coil = "2.0.0"
    const val acompanistNavigation = "0.26.1-alpha"
    const val junit4 = "4.13.2"
    const val espresso = "3.4.0"
    const val androidJunit = "1.1.3"
}

object Deps {
    val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    val compose_ui = "androidx.compose.ui:ui:${Versions.compose}"
    val compose_material = "androidx.compose.material:material:${Versions.compose}"
    val compose_junit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    val compose_debug = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
    val compose_tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    val compose_activity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    val compose_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"
    val compose_navigation = "androidx.navigation:navigation-compose:${Versions.lifecycle}"
    val acompanist_flowlayout =
        "com.google.accompanist:accompanist-flowlayout:${Versions.accompanist_flowlayout}"
    val acompanist_naviagtion =
        "com.google.accompanist:accompanist-navigation-animation:${Versions.acompanistNavigation}"
    val classpath_hilt_plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    val hilt_navigation =
        "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationForCompose}"
    val hilt_compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    val hilt_android_test = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
    val hilt_test = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okHttp3}"
    val okhttp3_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp3}"
    val coroutine_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val coroutine_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val coroutine_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycle_runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    val coil = "io.coil-kt:coil-compose:${Versions.coil}"
    val junit4 = "junit:junit:${Versions.junit4}"
    val android_junit = "androidx.test.ext:junit:${Versions.androidJunit}"
}

object Config {
    const val compileSdk = 33
    const val targetSdk = 32
    const val minSdk = 29
    const val versionCode = 1
    const val versionName = "1.0"
    const val base_url = "https://raw.githubusercontent.com/"
}