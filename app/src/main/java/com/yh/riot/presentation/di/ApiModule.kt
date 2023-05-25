package com.yh.riot.presentation.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.yh.riot.data.api.RiotService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggerInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(loggerInterceptor).build()
    }

    @Singleton
    @Provides
    fun provideNetworkJson(): Json = Json {
        isLenient = true // Json 큰따움표 느슨하게 체크
        ignoreUnknownKeys = true // Field 값이 없는 경우 무시
        coerceInputValues = true // "null" 이 들어간 경우 default Argument 값으로 대체
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, newWorkJson: Json): Retrofit {
        return Retrofit.Builder().baseUrl("http://ddragon.leagueoflegends.com/")
            .client(okHttpClient)
            .addConverterFactory(newWorkJson.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Singleton
    @Provides
    fun provideRiotService(retrofit: Retrofit): RiotService {
        return retrofit.create(RiotService::class.java)
    }

}