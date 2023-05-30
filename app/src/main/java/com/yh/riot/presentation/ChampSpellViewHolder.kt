package com.yh.riot.presentation

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yh.riot.data.model.Spell
import com.yh.riot.databinding.ItemChampSpellBinding

class ChampSpellViewHolder constructor(private val binding: ItemChampSpellBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindChampSpell(spell: Spell) {
        with(binding) {
            spellName.text = spell.name
            spellDescription.text = spell.description
            Glide.with(root)
                .load(spell.imageUrl)
                .into(binding.spellImage)
        }
    }
}