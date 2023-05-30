package com.yh.riot.data.source.remote

import android.util.Log
import com.yh.riot.data.api.RiotService
import com.yh.riot.data.model.ChampInfo
import com.yh.riot.data.model.LOLChamp
import com.yh.riot.data.model.RiotResponse
import javax.inject.Inject

class RiotRemoteDataSourceImpl @Inject constructor(private val riotService: RiotService) :
    RiotRemoteDataSource {
    override suspend fun getLOLChamp(): RiotResponse<LOLChamp> {
        Log.d("결과", "riotService.getLOLChamp() : " + riotService.getLOLChamp())
        return riotService.getLOLChamp()
    }

    override suspend fun getChampInfo(champId: String): RiotResponse<ChampInfo> {
        return riotService.getChampInfo(champId)
    }


}