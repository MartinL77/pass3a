package com.example.pass3a

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MedallistAdapter(
    private val medallists: List<Medallist>,
    private val onItemClicked: (Medallist) -> Unit
) : RecyclerView.Adapter<MedallistAdapter.MedallistViewHolder>() {

    class MedallistViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconText: TextView = view.findViewById(R.id.iconText)
        val countryText: TextView = view.findViewById(R.id.countryText)
        val subtitleText: TextView = view.findViewById(R.id.subtitleText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedallistViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_medallist, parent, false)

        return MedallistViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedallistViewHolder, position: Int) {
        val medallist = medallists[position]

        holder.countryText.text = medallist.country
        holder.subtitleText.text =
            "${medallist.code} • Gold: ${medallist.gold}, Silver: ${medallist.silver}, Bronze: ${medallist.bronze}"

        if (medallist.totalMedals >= 100) {
            holder.iconText.text = "🏆"
            holder.itemView.setBackgroundColor(Color.rgb(255, 248, 220))
        } else if (medallist.totalMedals > 0) {
            holder.iconText.text = "🥇"
            holder.itemView.setBackgroundColor(Color.rgb(235, 248, 255))
        } else {
            holder.iconText.text = "•"
            holder.itemView.setBackgroundColor(Color.WHITE)
        }

        holder.itemView.setOnClickListener {
            onItemClicked(medallist)
        }
    }

    override fun getItemCount(): Int = medallists.size
}