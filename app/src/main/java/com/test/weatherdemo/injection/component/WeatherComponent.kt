package com.test.weatherdemo.injection.component

import com.test.foundationlib.injection.PerComponentScope
import com.test.foundationlib.injection.component.ActivityComponent
import com.test.weatherdemo.injection.module.WeatherModule
import com.test.weatherdemo.ui.activity.WeatherActivity
import dagger.Component

/**
 * WeatherActivity Component which could inject the required object to it via corresponding Module
 *
 */
@PerComponentScope
@Component(dependencies = [ActivityComponent::class], modules = [WeatherModule::class])
interface WeatherComponent {
    fun inject(mainActivity: WeatherActivity)
}