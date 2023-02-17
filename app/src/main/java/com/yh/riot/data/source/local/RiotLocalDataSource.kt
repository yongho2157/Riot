package com.yh.riot.data.source.local

import androidx.lifecycle.LiveData
import com.yh.riot.data.model.LOLChamp

interface RiotLocalDataSource {

    suspend fun insertChampion(lolChamp: LOLChamp)

    suspend fun deleteChampion(lolChamp: LOLChamp)

    fun getAllChampion(): LiveData<List<LOLChamp>>

}