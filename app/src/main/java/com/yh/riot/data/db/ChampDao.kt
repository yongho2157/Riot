package com.yh.riot.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.yh.riot.data.model.LOLChamp

@Dao
interface ChampDao {

    @Insert
    suspend fun insertChampion(lolChamp: LOLChamp)

    @Delete
    suspend fun deleteChampion(lolChamp: LOLChamp)

    @Query("SELECT * FROM LOLChamp")
    fun getAllChampion(): LiveData<List<LOLChamp>>

}