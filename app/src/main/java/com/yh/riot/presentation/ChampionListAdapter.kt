package com.yh.riot.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yh.riot.data.model.LOLChamp
import com.yh.riot.databinding.ChampPreviewBinding

class ChampionListAdapter : RecyclerView.Adapter<ViewHolder>() {

    private val championList = mutableListOf<LOLChamp>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ChampPreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(championList[position])
    }

    override fun getItemCount(): Int =
        championList.size

    fun addAll(lolChamps: List<LOLChamp>) {
        championList.clear()
        championList.addAll(lolChamps)
        notifyDataSetChanged()
    }

}