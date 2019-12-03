package com.test.weatherdemo.data.bean

data class WeatherResponse(
    var latitude: Double,
    var longitude: Double,
    var timezone: String,
    var currently: CurrentlyDataDetail,
    var hourly: HourlyData,
    var daily: DailyData,
    var alerts: List<Alert>,
    var flags: Flag
)