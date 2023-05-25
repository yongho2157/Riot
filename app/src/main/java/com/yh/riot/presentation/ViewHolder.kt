package com.yh.riot.presentation

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.yh.riot.data.model.LOLChamp
import com.yh.riot.databinding.ChampPreviewBinding

class ViewHolder(private val binding: ChampPreviewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(lolChamp: LOLChamp) {
        binding.tvPreviewTitle.text = lolChamp.name
        Glide.with(binding.root)
            .load(lolChamp.url)
//            .listener(
//                GlidePalette.with(lolChamp.url)
//                    .use(BitmapPalette.Profile.MUTED_LIGHT)
//                    .intoCallBack { palette ->
//                        val rgb = palette?.dominantSwatch?.rgb
//                        if (rgb != null) {
//                            binding.cardView.setCardBackgroundColor(rgb)
//                        }
//                    }.crossfade(true)
//            ).
            .into(binding.ivPreviewImage)
    }

}