package com.yh.riot.data.repository

import androidx.lifecycle.LiveData
import com.yh.riot.data.model.ChampInfo
import com.yh.riot.data.model.LOLChamp
import com.yh.riot.data.model.RiotResponse
import com.yh.riot.data.source.local.RiotLocalDataSource
import com.yh.riot.data.source.remote.RiotRemoteDataSource
import com.yh.riot.domain.repository.RiotRepository
import javax.inject.Inject

class RiotRepositoryImpl @Inject constructor(
    private val riotRemoteDataSource: RiotRemoteDataSource,
    private val riotLocalDataSource: RiotLocalDataSource
) : RiotRepository {
    override suspend fun getLOLChamp(): RiotResponse<LOLChamp> =
        riotRemoteDataSource.getLOLChamp()

    override suspend fun getChampInfo(champId: String): RiotResponse<ChampInfo> =
        riotRemoteDataSource.getChampInfo(champId)

    override suspend fun insertChampion(lolChamp: LOLChamp) {
        riotLocalDataSource.insertChampion(lolChamp)
    }

    override suspend fun deleteChampion(lolChamp: LOLChamp) {
        riotLocalDataSource.deleteChampion(lolChamp)
    }

    override fun getAllChampion(): LiveData<List<LOLChamp>> =
        riotLocalDataSource.getAllChampion()

}