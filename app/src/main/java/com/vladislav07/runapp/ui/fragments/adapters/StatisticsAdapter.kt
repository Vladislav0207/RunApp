package com.vladislav07.runapp.ui.fragments.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vladislav07.runapp.R
import com.vladislav07.runapp.ui.models.StatisticsUI

class StatisticsAdapter(
    private val context: Context?,
    private val statisticsList: MutableList<StatisticsUI>
) : RecyclerView.Adapter<StatisticsAdapter.StatisticsViewHolder>() {


    class StatisticsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val week: TextView = itemView.findViewById(R.id.weekStatistics)
        val avTime: TextView = itemView.findViewById(R.id.timeStatistics)
        val avDistance: TextView = itemView.findViewById(R.id.distanceStatistics)
        val avSpeed: TextView = itemView.findViewById(R.id.speedStatistics)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StatisticsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.statistics_item, parent, false)
        return StatisticsViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: StatisticsViewHolder,
        position: Int
    ) {
        with(holder) {
            week.text = context?.getString(
                R.string.weekLog,
                statisticsList[position].weekNumber,
                statisticsList[position].firstDate,
                statisticsList[position].lastDate
            )
            avTime.text = context?.getString(
                R.string.av_time,
                statisticsList[position].avTime.toString()
            )
            avDistance.text = context?.getString(
                R.string.av_distance,
                statisticsList[position].avDistance.toString()
            )
            avSpeed.text = context?.getString(
                R.string.speed,
                statisticsList[position].avSpeed.toString()
            )
        }
    }

    override fun getItemCount(): Int {
        return statisticsList.size
    }
}