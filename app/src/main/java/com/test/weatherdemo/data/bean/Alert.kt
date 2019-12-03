package com.test.weatherdemo.data.bean

data class Alert(
    var title: String,
    var regions: List<String>,
    var severity: String,
    var time:Long,
    var expires:Long,
    var description:String,
    var uri:String
)