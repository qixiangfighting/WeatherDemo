package com.test.foundationlib.injection.component

import com.test.foundationlib.common.BaseApplication
import com.test.foundationlib.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * It is Application component
 *
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun appliCation(): BaseApplication
}
