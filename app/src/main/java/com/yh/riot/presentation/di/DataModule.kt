package com.yh.riot.presentation.di

import com.yh.riot.data.repository.RiotRepositoryImpl
import com.yh.riot.data.source.remote.RiotRemoteDataSource
import com.yh.riot.data.source.remote.RiotRemoteDataSourceImpl
import com.yh.riot.domain.repository.RiotRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun bindRiotRemoteDataSource(
        riotRemoteDataSourceImpl: RiotRemoteDataSourceImpl
    ): RiotRemoteDataSource

    @Singleton
    @Binds
    abstract fun bindRiotRepository(
        riotRepositoryImpl: RiotRepositoryImpl
    ): RiotRepository

}