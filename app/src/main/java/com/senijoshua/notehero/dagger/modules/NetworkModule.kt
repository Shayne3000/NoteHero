package com.senijoshua.notehero.dagger.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideMoshiConverterFactory() = MoshiConverterFactory.create()

    @Provides
    fun provideInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun provideOkHttp(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(loggingInterceptor)
        }.build()
    }

    @Provides
    fun provideRetrofit(httpClient: OkHttpClient, converterFactory: MoshiConverterFactory) =
        Retrofit.Builder().apply {
            client(httpClient)
            baseUrl("https://api.unsplash.com")
            addConverterFactory(converterFactory)
        }.build()
}
