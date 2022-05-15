/**
 *
 * 1. 在 Groovy 中，我们有一个 ext 的扩展，但是在 Kotlin 中是没有的，所以我们只能自己先声明一个局部变量，然后通过字符串模板引入，
 *
 * 2. classpath 引入的全局依赖，我们是要用大括号括起来，
 *
 * 3.还有一个 clean 的任务，这个也是需要改写的
 *
 */

val kotlin_version = "1.6.21"
val retrofit_version = "2.9.0"
val okhttp3_version = "4.9.3"
val okhttp3_logger_version = "4.9.3"
val dagger_version = "2.16"
val rxlifecycle_version = "2.2.1"

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }

    dependencies {
        // todo  classpatch 作用到底是干什么的
        classpath("com.android.tools.build:gradle:4.0.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath("com.google.gms:google-services:4.3.10")
    }


}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

//为什么可以这样写，这个tasks方法调用没有看到要传一个TaskContainerScope的扩展函数
tasks {
    val clean by registering(Delete::class){
        delete(buildDir)
    }
}
