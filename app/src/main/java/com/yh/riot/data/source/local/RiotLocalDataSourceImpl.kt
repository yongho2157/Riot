package com.yh.riot.data.source.local

import androidx.lifecycle.LiveData
import com.yh.riot.data.db.ChampDao
import com.yh.riot.data.model.LOLChamp
import javax.inject.Inject

class RiotLocalDataSourceImpl @Inject constructor(private val riotDao: ChampDao) : RiotLocalDataSource {
    override suspend fun insertChampion(lolChamp: LOLChamp) =
        riotDao.insertChampion(lolChamp)

    override suspend fun deleteChampion(lolChamp: LOLChamp) =
        riotDao.deleteChampion(lolChamp)

    override fun getAllChampion(): LiveData<List<LOLChamp>> =
        riotDao.getAllChampion()

}