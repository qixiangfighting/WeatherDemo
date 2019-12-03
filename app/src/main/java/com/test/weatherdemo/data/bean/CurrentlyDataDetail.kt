package com.test.weatherdemo.data.bean

data class CurrentlyDataDetail(
    var time: Long,
    var summary: String,
    var icon: String,
    var nearestStormDistance: Double,
    var precipIntensity: Double,
    var precipIntensityError: Double,
    var precipProbability: Double,
    var precipType: String,
    var temperature: Double,
    var apparentTemperature: Double,
    var dewPoint: Double,
    var humidity: Double,
    var pressure: Double,
    var windSpeed: Double,
    var windGust: Double,
    var windBearing: Double,
    var cloudCover: Double,
    var uvIndex: Double,
    var visibility: Double,
    var ozone: Double
)