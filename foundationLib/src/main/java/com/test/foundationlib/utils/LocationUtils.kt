package com.test.foundationlib.utils

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.core.app.ActivityCompat

/**
 * Location util to get lat and lon for searching weather by location
 */
object LocationUtils {

    private lateinit var mLocationManager: LocationManager

    fun isLocationEnabled(context: Context): Boolean {
        val lm = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER) || lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    @SuppressLint("MissingPermission")
    fun getLocation(context: Context): Location? {
        if (!isLocationPermissionsGranted(context)) {
            return null
        }
        mLocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val lastKnownLocation = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

        mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0F, object : LocationListener {
            override fun onLocationChanged(location: Location?) {

            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            }

            override fun onProviderEnabled(provider: String?) {
            }

            override fun onProviderDisabled(provider: String?) {
            }
        })

        return lastKnownLocation
    }

    fun isLocationPermissionsGranted(context: Context): Boolean {
        return !(ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED)
    }
}

