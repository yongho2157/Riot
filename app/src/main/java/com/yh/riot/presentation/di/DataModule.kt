package com.yh.riot.presentation.di

import android.content.Context
import androidx.room.Room
import com.yh.riot.data.db.ChampDao
import com.yh.riot.data.db.RiotDataBase
import com.yh.riot.data.repository.RiotRepositoryImpl
import com.yh.riot.data.source.local.RiotLocalDataSource
import com.yh.riot.data.source.local.RiotLocalDataSourceImpl
import com.yh.riot.data.source.remote.RiotRemoteDataSource
import com.yh.riot.data.source.remote.RiotRemoteDataSourceImpl
import com.yh.riot.domain.repository.RiotRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Singleton
    @Binds
    abstract fun bindRiotRemoteDataSource(
        riotRemoteDataSourceImpl: RiotRemoteDataSourceImpl,
    ): RiotRemoteDataSource

    @Singleton
    @Binds
    abstract fun bindLocalDataSource(
        riotLocalDataSourceImpl: RiotLocalDataSourceImpl
    ): RiotLocalDataSource

    @Singleton
    @Binds
    abstract fun bindRiotRepository(
        riotRepositoryImpl: RiotRepositoryImpl
    ): RiotRepository

}