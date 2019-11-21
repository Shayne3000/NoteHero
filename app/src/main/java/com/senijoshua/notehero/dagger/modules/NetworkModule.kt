package com.senijoshua.notehero.dagger.modules

import android.util.Base64
import com.senijoshua.notehero.data.sources.remote.ThumbRemote
import com.senijoshua.notehero.utils.annotations.AppScope
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val ACCESS_KEY =
    "TXpFMk9USmxNR0ptWkRobE1tWmpaREppTldSbE9UTXhNamN5TlRFNFlt" +
        "RmlOVEprWmpZd09ESXpNekV3TkRkbU5HTXdNalkwTldNeE9XWm1NR1kwTWc9PQ=="

@Module
class NetworkModule {

    @AppScope
    @Provides
    fun provideMoshiConverterFactory() = MoshiConverterFactory.create()

    @AppScope
    @Provides
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @AppScope
    @Provides
    fun provideOkHttp(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(authInterceptor)
            addInterceptor(loggingInterceptor)
        }.build()
    }

    @AppScope
    @Provides
    fun provideRetrofit(httpClient: OkHttpClient, converterFactory: MoshiConverterFactory) =
        Retrofit.Builder().apply {
            client(httpClient)
            baseUrl("https://api.unsplash.com")
            addConverterFactory(converterFactory)
        }.build()

    @AppScope // todo Use AppScope for now till we perhaps create a different Subcomponent for notes
    @Provides
    fun provideNotesThumbRemote(retrofit: Retrofit) = retrofit.create(ThumbRemote::class.java)

    private val authInterceptor = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val requestChain = chain.request()
            return chain.proceed(
                requestChain.newBuilder()
                    .addHeader(
                        "Authorization","Client-ID ${decodeAccessKey(ACCESS_KEY)}"
                              )
                    .addHeader("Accept-Version", "v1")
                    .build())
        }
    }

    private fun decodeAccessKey(input: String): String {
        val initialDecode = Base64.decode(input, Base64.DEFAULT)
        return String(Base64.decode(initialDecode, Base64.DEFAULT))
    }
}
