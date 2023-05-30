package com.yh.riot.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
data class RiotResponse<T>(
    val type: String,
    val format: String,
    val version: String,
    val data: Map<String, T>
)

@Serializable
data class ChampInfo(
    val id: String,
    val name: String,
    val skins: List<Skin>,
    val spells: List<Spell>
)

@Serializable
data class Skin(
    val id: String,
    val num: Int,
    val name: String,
    val chromas: Boolean
)

@Serializable
data class Spell(
    val id: String,
    val name: String,
    val description: String,
    val tooltip: String,
    val imageUrl: String = "http://ddragon.leagueoflegends.com/cdn/13.10.1/img/spell/$id.png"
)

@Serializable
@Parcelize
@Entity
data class LOLChamp(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val title: String,
    val blurb: String,
    val tags: List<String>,
    var url: String = "https://ddragon.leagueoflegends.com/cdn/img/champion/loading/${id}_0.jpg"
) : Parcelable