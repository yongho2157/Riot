package com.yh.riot.domain.model

data class ChampInfo(
    var champId: String = "",
    var champName: String = "",
    var spellId: String = "",
    var spellName: String = "",
    val spellImageUrl: String = "http://ddragon.leagueoflegends.com/cdn/13.10.1/img/spell/$spellId.png"
)
