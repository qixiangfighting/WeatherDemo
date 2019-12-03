package com.test.weatherdemo.data.bean

import android.os.Parcel
import android.os.Parcelable

data class HourlyDataDetail (
    var time: Long,
    var summary: String = "",
    var icon: String = "",
    var precipIntensity: Double,
    var precipProbability: Double,
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
    var ozone: Double) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(time)
        parcel.writeString(summary)
        parcel.writeString(icon)
        parcel.writeDouble(precipIntensity)
        parcel.writeDouble(precipProbability)
        parcel.writeDouble(temperature)
        parcel.writeDouble(apparentTemperature)
        parcel.writeDouble(dewPoint)
        parcel.writeDouble(humidity)
        parcel.writeDouble(pressure)
        parcel.writeDouble(windSpeed)
        parcel.writeDouble(windGust)
        parcel.writeDouble(windBearing)
        parcel.writeDouble(cloudCover)
        parcel.writeDouble(uvIndex)
        parcel.writeDouble(visibility)
        parcel.writeDouble(ozone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HourlyDataDetail> {
        override fun createFromParcel(parcel: Parcel): HourlyDataDetail {
            return HourlyDataDetail(parcel)
        }

        override fun newArray(size: Int): Array<HourlyDataDetail?> {
            return arrayOfNulls(size)
        }
    }
}
