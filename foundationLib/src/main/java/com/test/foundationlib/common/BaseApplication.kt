package com.test.foundationlib.common

import android.app.Application
import com.test.foundationlib.injection.component.AppComponent
import com.test.foundationlib.injection.component.DaggerAppComponent
import com.test.foundationlib.injection.module.AppModule

/**
 * BaseApplication
 *
 * Provider the AppComponent which use for dagger inject, also provide the single instance application
 *
 */
open class BaseApplication : Application() {

    lateinit var appComponent: AppComponent
    init {
        synchronized(BaseApplication::class.java) {
            application = this
        }
    }

    override fun onCreate() {
        super.onCreate()
        initAppInjection()
    }

    /**
     * Application Component Initialize
     */
    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        @Volatile
        var application: Application? = null
            private set
    }
}
