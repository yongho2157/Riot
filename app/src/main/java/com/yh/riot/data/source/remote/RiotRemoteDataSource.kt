package com.yh.riot.data.source.remote

import com.yh.riot.data.model.LOLChamp
import com.yh.riot.data.model.RiotResponse

interface RiotRemoteDataSource {

    suspend fun getLOLChamp(): RiotResponse<LOLChamp>

}