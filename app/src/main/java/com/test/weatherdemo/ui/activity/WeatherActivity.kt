package com.test.weatherdemo.ui.activity

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.tbruyelle.rxpermissions2.RxPermissions
import com.test.foundationlib.ui.activity.BaseMvpActivity
import com.test.foundationlib.utils.DateUtils
import com.test.foundationlib.utils.LocationUtils
import com.test.weatherdemo.R
import com.test.weatherdemo.common.Constant
import com.test.weatherdemo.data.bean.HourlyDataDetail
import com.test.weatherdemo.data.bean.WeatherResponse
import com.test.weatherdemo.injection.component.DaggerWeatherComponent
import com.test.weatherdemo.injection.module.WeatherModule
import com.test.weatherdemo.presenter.WeatherPresenter
import com.test.weatherdemo.presenter.view.WeatherView
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_weather.*
import java.util.*
import kotlin.collections.ArrayList

/**
 *  Architecture of weather:  MVP+Dagger2+Retrofit2+OkHttp3+Kotlin
 *
 *  Activity: just update UI or handle click event
 *  Presenter: do logic thing, it contains the layer of Service which contains Repository layer, use
 *  interface to split each layer
 *
 *
 *
 */
class WeatherActivity : BaseMvpActivity<WeatherPresenter>(), WeatherView {

    private var rxPermissionDispose: Disposable? = null
    private var timeZone: String? = null
    private var hourlyDatas: ArrayList<HourlyDataDetail>? = null


    override fun injectComponent() {
        DaggerWeatherComponent.builder().activityComponent(mActivityComponent).weatherModule(WeatherModule()).build()
            .inject(this)
        mPresenter.mView = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        getWeatherByLocation()
    }

    fun checkWeatherDetail(view: View) {
        if (!LocationUtils.isLocationPermissionsGranted(this) || hourlyDatas == null) {
            getWeatherByLocation()
            return
        }
        Intent(this, WeatherDetailActivity::class.java).apply {
            putExtra(Constant.HOURLY_DATA, hourlyDatas)
            putExtra(Constant.TIME_ZONE, timeZone)
            startActivity(this)
        }
    }


    private fun getWeatherByLocation() {

        if (!LocationUtils.isLocationEnabled(this)) {
            Toast.makeText(this, getString(R.string.unsupport_location), Toast.LENGTH_SHORT).show()
            return
        }
        rxPermissionDispose = RxPermissions(this).request(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
        ).subscribe { isGrant ->
            val location = LocationUtils.getLocation(this)
            if (isGrant && location != null) {
                mPresenter.getWeatherInfoByLocation("${location.latitude},${location.longitude}")
            } else {
                val daultText = getString(R.string.default_text)
                dateTv.text = daultText
                iconTv.text = daultText
                highTempTv.text = daultText
                lowTempTv.text = daultText
                Toast.makeText(this, getString(R.string.location_permission_reminder), Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onWeatherInfoResult(result: WeatherResponse) {
        dateTv.text = DateUtils.format(Date(result.currently.time * 1000), result.timezone)
        iconTv.text = result.currently.icon
        highTempTv.text =
            getString(R.string.high_temp, DateUtils.convertFtemp2Ctemp(result.daily.data[0].temperatureHigh))
        lowTempTv.text = getString(R.string.low_temp, DateUtils.convertFtemp2Ctemp(result.daily.data[0].temperatureLow))




        val mutableHourlyDatas: MutableList<HourlyDataDetail> = result.hourly.data.toMutableList()
        // sort the hourly data according to timestamp
        mutableHourlyDatas.sortBy {
            it.time
        }
        // filter the data low the current time,that is, filter the past time weather
        val filter = mutableHourlyDatas.filter {
            it.time >= result.currently.time

        }

        // treat as params pass to the detail screen
        hourlyDatas = ArrayList(filter)
        timeZone = result.timezone
    }

    override fun onError(text: String) {
        super.onError(text)
        Toast.makeText(this, getString(R.string.search_failure_reminder), Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        rxPermissionDispose?.dispose()
    }

}
