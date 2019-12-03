package com.test.weatherdemo.data.bean

data class DailyWeather(var summary:String, var icon:String, var data:List<CurrentlyDataDetail> )