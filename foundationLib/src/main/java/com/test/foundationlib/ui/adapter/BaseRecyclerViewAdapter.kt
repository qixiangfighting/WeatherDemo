package com.test.foundationlib.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView

/**
 * Base RecyclerViewAdapter
 *
 */
abstract class BaseRecyclerViewAdapter<T, VH : RecyclerView.ViewHolder>(var mContext: Context) : RecyclerView.Adapter<VH>() {

    /**
     * Item click
     *
     */
    var mItemClickListener: OnItemClickListener<T>? = null

    /**
     * data source
     */
    var dataList: MutableList<T> = mutableListOf()



    fun setData(sources: MutableList<T>) {
        dataList = sources
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            if (mItemClickListener != null)
                mItemClickListener!!.onItemClick(dataList[position], position)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }



    interface OnItemClickListener<in T> {
        fun onItemClick(item: T, position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener<T>) {
        this.mItemClickListener = listener
    }
}
