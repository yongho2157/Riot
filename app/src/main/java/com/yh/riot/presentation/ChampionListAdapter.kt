package com.yh.riot.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yh.riot.data.model.LOLChamp
import com.yh.riot.databinding.ChampPreviewBinding

class ChampionListAdapter : RecyclerView.Adapter<LOLChampViewHolder>() {

    private val championList = mutableListOf<LOLChamp>()
    private var onItemClickListener: ((LOLChamp) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LOLChampViewHolder {
        val binding = ChampPreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LOLChampViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LOLChampViewHolder, position: Int) {
        val champ = championList[position]
        holder.bind(championList[position])
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(champ) }
        }
    }

    fun setOnItemClickListener(listener: (LOLChamp) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int =
        championList.size

    fun addAll(lolChamps: List<LOLChamp>) {
        championList.clear()
        championList.addAll(lolChamps)
        notifyDataSetChanged()
    }

}