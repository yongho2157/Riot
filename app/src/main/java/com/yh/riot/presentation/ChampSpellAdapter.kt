package com.yh.riot.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yh.riot.data.model.Spell
import com.yh.riot.databinding.ItemChampSpellBinding

class ChampSpellAdapter : RecyclerView.Adapter<ChampSpellViewHolder>() {

    private val champSpells: ArrayList<Spell> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampSpellViewHolder {
        val binding = ItemChampSpellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChampSpellViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return champSpells.size
    }

    override fun onBindViewHolder(holder: ChampSpellViewHolder, position: Int) {
        val spell = champSpells[position]
        holder.bindChampSpell(spell)
    }

    fun addChampSpell(spell: Spell) {
        champSpells.add(spell)
        notifyDataSetChanged()
    }

    fun deleteAllChampSpells() {
        champSpells.clear()
    }

}