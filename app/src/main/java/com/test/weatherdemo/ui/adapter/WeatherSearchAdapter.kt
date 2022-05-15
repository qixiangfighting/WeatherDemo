package com.test.weatherdemo.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.foundationlib.ui.adapter.BaseRecyclerViewAdapter
import com.test.foundationlib.utils.DateUtils
import com.test.foundationlib.utils.DateUtils.FORMAT_SHORT_SPE_
import com.test.weatherdemo.R
import com.test.weatherdemo.data.bean.HourlyDataDetail
import kotlinx.android.synthetic.main.layout_weather_location_item.view.*
import java.util.*

/**
 *  Adapter for showing weather info
 *
 */
class WeatherSearchAdapter(val context: Context, val timeZone: String) :
    BaseRecyclerViewAdapter<HourlyDataDetail, WeatherSearchAdapter.ViewHolder>(context) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(mContext)
            .inflate(
                R.layout.layout_weather_location_item,
                parent,
                false
            )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val hourlyDataDetail = dataList[position]
        holder.itemView.timeTv.text = DateUtils.format(Date(hourlyDataDetail.time * 1000), timeZone, FORMAT_SHORT_SPE_)
        holder.itemView.iconTv.text = hourlyDataDetail.icon
        holder.itemView.tempTv.text =
            context.getString(R.string.high_temp, DateUtils.convertFtemp2Ctemp(hourlyDataDetail.temperature))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

}
