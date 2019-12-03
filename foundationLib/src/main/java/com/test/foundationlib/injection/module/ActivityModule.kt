package com.test.foundationlib.injection.module

import android.app.Activity
import com.test.foundationlib.injection.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * ActivityModule is for ActivityComponent
 *
 */
@Module
class ActivityModule(private val activity: Activity) {

    @ActivityScope
    @Provides
    fun provideActivity(): Activity {
        return this.activity
    }
}
