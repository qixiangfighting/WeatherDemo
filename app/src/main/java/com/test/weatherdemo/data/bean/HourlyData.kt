package com.test.weatherdemo.data.bean

import android.os.Parcel
import android.os.Parcelable


data class HourlyData(
    var summary: String,
    var icon: String,
    var data: List<HourlyDataDetail>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.createTypedArrayList(HourlyDataDetail)!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(summary)
        parcel.writeString(icon)
        parcel.writeTypedList(data)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HourlyData> {
        override fun createFromParcel(parcel: Parcel): HourlyData {
            return HourlyData(parcel)
        }

        override fun newArray(size: Int): Array<HourlyData?> {
            return arrayOfNulls(size)
        }
    }
}