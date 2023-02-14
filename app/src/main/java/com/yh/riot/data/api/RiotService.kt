package com.yh.riot.data.api

import com.yh.riot.data.model.LOLChamp
import com.yh.riot.data.model.RiotResponse
import retrofit2.http.GET

interface RiotService {

    @GET("cdn/13.1.1/data/ko_KR/champion.json")
    suspend fun getLOLChamp(): RiotResponse<LOLChamp>

}