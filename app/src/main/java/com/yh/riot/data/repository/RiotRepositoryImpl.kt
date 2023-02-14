package com.yh.riot.data.repository

import com.yh.riot.data.model.LOLChamp
import com.yh.riot.data.model.RiotResponse
import com.yh.riot.data.source.remote.RiotRemoteDataSource
import com.yh.riot.domain.repository.RiotRepository
import javax.inject.Inject

class RiotRepositoryImpl @Inject constructor(private val riotRemoteDataSource: RiotRemoteDataSource) : RiotRepository {
    override suspend fun getLOLChamp(): RiotResponse<LOLChamp> =
        riotRemoteDataSource.getLOLChamp()


}