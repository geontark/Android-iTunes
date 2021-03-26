object Kotlin {
    const val standardLibrary = "1.4.10"
    const val coroutines = "1.3.9"
}

object AndroidSdk {
    const val min = 19
    const val compile = 29
    const val target = compile
}

object AndroidClient {
    const val appId = "com.devtak.watcha"
    const val versionCode = 1
    const val versionName = "1.0"
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object BuildPlugins {
    object Versions {
        const val buildToolsVersion = "4.1.0"
        const val gradleVersion = "6.6.1"
    }
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.standardLibrary}"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
}

object ScriptPlugins {
    const val infrastructure = "scripts.infrastructure"
    const val variants = "scripts.variants"
    const val quality = "scripts.quality"
    const val compilation = "scripts.compilation"
}

object Libraries {
    private object Versions {
        const val appCompat = "1.2.0"
        const val constraintLayout = "2.0.2"
        const val recyclerView = "1.1.0"
        const val cardView = "1.0.0"
        const val material = "1.1.0"
        const val lifecycle = "2.2.0"
        const val lifecycleExtensions = "2.1.0"
        const val annotations = "1.1.0"
        const val ktx = "1.3.2"
        const val viewpager2 = "1.0.0"
        const val glide = "4.11.0"
        const val retrofit = "2.9.0"
        const val okHttpLoggingInterceptor = "4.9.0"
        const val kotlinSerialization = "1.0.1"
        const val googleServicesLocation = "17.1.0"
        const val koin = "2.2.2"
        const val rxJava2 = "2.2.2"
        const val rxAndroid2 = "2.1.0"
        const val rxJava3 = "3.0.11"
        const val rxAndroid3 = "3.0.0"
        const val roomDB = "2.2.6"
        const val navigation = "2.3.4"
        const val pullRefresh = "1.1.0"
        const val multidex = "2.0.1"
        // okhttp for api 19
        const val okhttpFor19 = "3.12.12"
    }

    const val kotlinStdLib                  = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Kotlin.standardLibrary}"
    const val kotlinCoroutines              = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Kotlin.coroutines}"
    const val kotlinCoroutinesAndroid       = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Kotlin.coroutines}"
    const val appCompat                     = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout              = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore                       = "androidx.core:core-ktx:${Versions.ktx}"
    const val lifecycleCompiler             = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val viewModel                     = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData                      = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleExtensions           = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensions}"
    const val cardView                      = "androidx.cardview:cardview:${Versions.cardView}"
    const val recyclerView                  = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val material                      = "com.google.android.material:material:${Versions.material}"
    const val androidAnnotations            = "androidx.annotation:annotation:${Versions.annotations}"
    const val viewpager2                    = "androidx.viewpager2:viewpager2:${Versions.viewpager2}"
    const val glide                         = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val retrofit                      = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitAdapterForRxJava2     = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val retrofitConverterForRxJava2   = "com.squareup.retrofit2:converter-scalars:${Versions.retrofit}"
    const val okHttpLoggingInterceptor      = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpLoggingInterceptor}"
    const val okhttpFor19                   = "com.squareup.okhttp3:okhttp:${Versions.okhttpFor19}"
    const val kotlinSerialization           = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerialization}"
    const val googleServicesLocation        = "com.google.android.gms:play-services-location:${Versions.googleServicesLocation}"
    const val koinCore                      = "org.koin:koin-core:${Versions.koin}"
    const val koinAndroid                   = "org.koin:koin-android:${Versions.koin}"
    const val andridKoinScope               = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val androidKoinViewModel          = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val androidKoinScope              = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val androidKoinFragment           = "org.koin:koin-androidx-fragment:${Versions.koin}"
    const val androidKoinWorkManager        = "org.koin:koin-androidx-workmanager:${Versions.koin}"
    const val androidKoinCompose            = "org.koin:koin-androidx-compose:${Versions.koin}"
    const val androidKoinExt                = "org.koin:koin-androidx-ext:${Versions.koin}"
    const val rxJava2                       = "io.reactivex.rxjava2:rxjava:${Versions.rxJava2}"
    const val rxAndroid2                    = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid2}"
    const val rxJava3                       = "io.reactivex.rxjava3:rxjava:${Versions.rxJava3}"
    const val rxAndroid3                    = "io.reactivex.rxjava3:rxandroid:${Versions.rxAndroid3}"
    const val roomDB                        = "androidx.room:room-runtime:${Versions.roomDB}"
    const val roomDBForRxjava2              = "androidx.room:room-rxjava2:${Versions.roomDB}"
    const val roomDBCompiler                = "androidx.room:room-compiler:${Versions.roomDB}"
    const val navigationKtx                 = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationFragment            = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val pullRefresh                   = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.pullRefresh}"
    const val multidex                      = "androidx.multidex:multidex:${Versions.multidex}"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.13.1"
        const val mockk = "1.10.0"
        const val robolectric = "4.4"
        const val kluent = "1.14"
        const val testRunner = "1.1.0"
        const val espressoCore = "3.2.0"
        const val espressoIntents = "3.1.0"
        const val testExtensions = "1.1.1"
        const val testRules = "1.1.0"
        const val kotlinKoinTest = "2.1.0"
        const val roomDBTest = "2.2.6"
    }

    const val junit4          = "junit:junit:${Versions.junit4}"
    const val mockk           = "io.mockk:mockk:${Versions.mockk}"
    const val robolectric     = "org.robolectric:robolectric:${Versions.robolectric}"
    const val kluent          = "org.amshove.kluent:kluent:${Versions.kluent}"
    const val testRunner      = "androidx.test:runner:${Versions.testRunner}"
    const val testRules       = "androidx.test:rules:${Versions.testRules}"
    const val espressoCore    = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val espressoIntents = "androidx.test.espresso:espresso-intents:${Versions.espressoIntents}"
    const val testExtJunit    = "androidx.test.ext:junit:${Versions.testExtensions}"
    const val kotlinKoinTest  = "org.koin:koin-test:${Versions.kotlinKoinTest}"
    const val roomDBTest        = "androidx.room:room-testing:${Versions.roomDBTest}"
}

object DevLibraries {
    private object Versions {
        const val leakCanary = "2.5"
    }

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
}

object NaverLibraries {
    private object Versions {
        const val naverMapSdk = "3.10.0"
    }

    const val naverMapSdk = "com.naver.maps:map-sdk:${Versions.naverMapSdk}"
}