package com.yh.riot.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RiotResponse<T>(
    val type: String,
    val format: String,
    val version: String,
    val data: Map<String, T>
)

@Serializable
data class LOLChamp(
    val id: String,
    val name: String,
    val title: String,
    val blurb: String,
    val tags: List<String>,
    val url: String = "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + id + "_0.jpg"
)