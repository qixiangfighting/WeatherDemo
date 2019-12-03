package com.test.weatherdemo.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.kotlin.base.ui.activity.BaseActivity
import com.test.weatherdemo.R
import com.test.weatherdemo.common.Constant
import com.test.weatherdemo.data.bean.HourlyDataDetail
import com.test.weatherdemo.ui.adapter.WeatherSearchAdapter
import kotlinx.android.synthetic.main.activity_recent_search.*

/**
 * Check the recent search locations
 *
 */
class WeatherDetailActivity : BaseActivity() {
    private lateinit var weatherSerachAdapter: WeatherSearchAdapter
    private lateinit var hourlyDatas: MutableList<HourlyDataDetail>
    private lateinit var timeZone: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recent_search)
        val datas = intent.getParcelableArrayListExtra<HourlyDataDetail>(Constant.HOURLY_DATA)
        this.timeZone = intent.getStringExtra(Constant.TIME_ZONE)
        this.hourlyDatas = datas.toMutableList()
        initView()
    }

    private fun initView() {
        this.weatherSerachAdapter = WeatherSearchAdapter(this, timeZone)
        searchLocationsLv.adapter = this.weatherSerachAdapter
        this.weatherSerachAdapter.dataList = hourlyDatas
        searchLocationsLv.layoutManager = LinearLayoutManager(this)
    }

}