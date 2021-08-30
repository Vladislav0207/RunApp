package com.vladislav07.runapp.ui.fragments.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vladislav07.runapp.R
import com.vladislav07.runapp.ui.fragments.callbacks.JogItemClick
import com.vladislav07.runapp.ui.models.JogUI

class JogAdapter(
    private val context: Context?,
    private val jogList: MutableList<JogUI>,
    private val jogCallback: JogItemClick
) : RecyclerView.Adapter<JogAdapter.JogViewHolder>() {


    class JogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date: TextView = itemView.findViewById(R.id.dateJog)
        val time: TextView = itemView.findViewById(R.id.timeJog)
        val distance: TextView = itemView.findViewById(R.id.distanceJog)
        val speed: TextView = itemView.findViewById(R.id.speedJog)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): JogViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.jog_item, parent, false)
        val holder = JogViewHolder(itemView)
        holder.itemView.setOnClickListener {
            jogCallback.updateJog(holder.adapterPosition)
        }
        return holder
    }

    override fun onBindViewHolder(
        holder: JogViewHolder,
        position: Int
    ) {
        holder.date.text = jogList[position].date
        holder.time.text = context?.getString(R.string.time, jogList[position].time.toString())
        holder.distance.text = context?.getString(R.string.distance, jogList[position].distance.toString())
        holder.speed.text = context?.getString(R.string.speed, jogList[position].speed.toString())
    }

    override fun getItemCount(): Int {
        return jogList.size
    }

}