package com.yh.riot.presentation

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yh.riot.data.model.LOLChamp
import com.yh.riot.databinding.ChampPreviewBinding

class ViewHolder(private val binding: ChampPreviewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(lolChamp: LOLChamp) {
        binding.tvPreviewTitle.text = lolChamp.name
        Glide.with(binding.root)
            .load(lolChamp.url)
            .into(binding.ivPreviewImage)
    }

}