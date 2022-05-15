//Convert Grovy gradle to kotlin kts rerfer to
// todo buildSrc是做什么的？，如何基于kts写 plugin 乃至于 transform
//https://juejin.cn/post/6974277501228941319,
// https://juejin.cn/post/6844904050798886919,
// https://juejin.cn/post/6844903667326255112,
// https://docs.gradle.org/current/userguide/kotlin_dsl.html

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
}

// todo 如何抽取成可以公用的
val kotlin_version = "1.6.21"
val retrofit_version = "2.9.0"
val okhttp3_version = "4.9.3"
val okhttp3_logger_version = "4.9.3"
val dagger_version = "2.16"
val rxlifecycle_version = "2.2.1"

android{
    compileSdkVersion(32)
    defaultConfig{
        applicationId = "com.test.weatherdemo"
        //属性和函数的方式
        minSdkVersion(23)
        targetSdk = 32
//        targetSdkVersion(32)
        versionCode = 1
        versionName = "1.0"



    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions{
        jvmTarget = "1.8"
    }
    buildTypes{
        getByName("release"){
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug"){
        }
    }

    // test 这快还可以设置很多
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
        unitTests.apply {
            all {
                isReturnDefaultValues = true
                it.maxParallelForks = 4
                it.maxHeapSize = "4096m"
                it.jvmArgs = listOf("-XX:MaxPermSize=2048m", "-noverify")
            }
        }
    }

    namespace = "com.test.weatherdemo"

}

dependencies{
    //RxAndroid
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.12")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

    //OkHttp3
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")


    //Dagger2
    api("com.google.dagger:dagger:2.16")
    implementation(project(mapOf("path" to ":foundationLib")))
    kapt("com.google.dagger:dagger-compiler:2.16")


    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.recyclerview:recyclerview:1.2.1")


    //firebase
    implementation(platform("com.google.firebase:firebase-bom:30.0.1"))
    implementation("com.google.firebase:firebase-analytics-ktx")

    implementation("com.github.tbruyelle:rxpermissions:0.10.2")
    implementation("com.trello.rxlifecycle2:rxlifecycle-kotlin:2.2.1")
    implementation("com.trello.rxlifecycle2:rxlifecycle-components:2.2.1")


    testImplementation ("junit:junit:4.13.2")
    testImplementation ("org.mockito:mockito-core:3.3.3")
    testImplementation ("org.robolectric:robolectric:4.4")
}
