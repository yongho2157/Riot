package com.yh.riot.domain.repository

import androidx.lifecycle.LiveData
import com.yh.riot.data.model.ChampInfo
import com.yh.riot.data.model.LOLChamp
import com.yh.riot.data.model.RiotResponse

interface RiotRepository {

    suspend fun getLOLChamp(): RiotResponse<LOLChamp>

    suspend fun getChampInfo(champId: String): RiotResponse<ChampInfo>

    suspend fun insertChampion(lolChamp: LOLChamp)

    suspend fun deleteChampion(lolChamp: LOLChamp)

    fun getAllChampion(): LiveData<List<LOLChamp>>

}