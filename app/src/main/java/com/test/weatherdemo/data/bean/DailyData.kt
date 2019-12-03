package com.test.weatherdemo.data.bean

data class DailyData(
    var summary: String,
    var icon: String,
    var data: List<DailyDataDetail>
)