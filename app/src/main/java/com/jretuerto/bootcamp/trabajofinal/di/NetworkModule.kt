package com.jretuerto.bootcamp.di

import com.jretuerto.bootcamp.rest.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pe.com.bootcamp.jretuerto.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    private const val API_BASE_URL = Constants.BASE_URL


    @Provides
    fun provideHTTPLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return httpLoggingInterceptor
    }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            //.addInterceptor(AuthInterceptor(BuildConfig.API_KEY))
                /*
            .addInterceptor { chain ->

                val token = Constants.API_TOKEN
                val typeToken = Constants.TIPO_TOKEN

                if (Constants.API_TOKEN!!.isNotEmpty()) {
                    val newRequest = chain.request().newBuilder()
                        .addHeader(
                            "Authorization",
                            "$typeToken $token"
                        )
                        .build()
                    chain.proceed(newRequest)
                } else {
                    val newRequest = chain.request().newBuilder().build()
                    chain.proceed(newRequest)
                }
            }
                 */
            .readTimeout(Constants.REST_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(Constants.REST_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(Constants.REST_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideCharacterService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}