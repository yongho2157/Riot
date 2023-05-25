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
@Parcelize
@Entity
data class LOLChamp(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val title: String,
    val blurb: String,
    val tags: List<String>,
    val url: String = "https://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + id + "_0.jpg"
) : Parcelable