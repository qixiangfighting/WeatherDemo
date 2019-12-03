package com.test.foundationlib.injection.component

import android.app.Activity
import com.test.foundationlib.common.BaseApplication
import com.test.foundationlib.injection.ActivityScope
import com.test.foundationlib.injection.module.ActivityModule
import com.test.foundationlib.injection.module.LifecycleProviderModule
import com.trello.rxlifecycle2.LifecycleProvider
import dagger.Component

/**
 *  It is Dagger2 component
 *  It provides activity, application, lifecycleProvider for presenter
 */
@ActivityScope
@Component(dependencies = [AppComponent::class],modules = [ActivityModule::class, LifecycleProviderModule::class])
interface ActivityComponent {
    fun activity():Activity
    fun application(): BaseApplication
    fun lifecycleProvider(): LifecycleProvider<*>
}
