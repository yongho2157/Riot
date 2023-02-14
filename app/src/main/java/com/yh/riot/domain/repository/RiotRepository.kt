package com.yh.riot.domain.repository

import com.yh.riot.data.model.LOLChamp
import com.yh.riot.data.model.RiotResponse

interface RiotRepository {

    suspend fun getLOLChamp(): RiotResponse<LOLChamp>

}