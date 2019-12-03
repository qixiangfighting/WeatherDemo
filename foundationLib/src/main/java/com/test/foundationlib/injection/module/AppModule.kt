package com.test.foundationlib.injection.module

import com.test.foundationlib.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * ActivityModule is for Application
 *
 */
@Module
class AppModule(private val application: BaseApplication) {

    @Singleton
    @Provides
    fun provideContext():BaseApplication{
        return this.application
    }
}
