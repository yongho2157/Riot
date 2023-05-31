package com.yh.riot.data.mapper

import com.yh.riot.data.model.ChampInfo
import com.yh.riot.data.model.RiotResponse

object ChampInfoMapper {

    fun mapperToChampInfo(riotResponse: RiotResponse<ChampInfo>): com.yh.riot.domain.model.ChampInfo {
        val champInfo = com.yh.riot.domain.model.ChampInfo()
        for (i in riotResponse.data.values.indices) {
            for (spell in riotResponse.data[""]!!.spells) {
                champInfo.spellId = spell.id

            }
        }

    }

}