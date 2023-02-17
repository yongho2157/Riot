package com.yh.riot.presentation.di

import android.content.Context
import androidx.room.Room
import com.yh.riot.data.db.ChampDao
import com.yh.riot.data.db.RiotDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Singleton
    @Provides
    fun provideChampDao(riotDataBase: RiotDataBase): ChampDao {
        return riotDataBase.champDao()
    }

    @Singleton
    @Provides
    fun provideRiotDatabase(@ApplicationContext context: Context): RiotDataBase =
        Room.databaseBuilder(
            context,
            RiotDataBase::class.java,
            "Riot.db"
        ).build()
}