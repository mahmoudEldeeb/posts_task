package com.fudex.khaznatask.di

import com.fudex.khaznatask.posts.data.remote.ApiService
import com.fudex.khaznatask.util.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@InstallIn(ApplicationComponent::class)

@Module
object NetworkModule {

    @Provides
    fun provideBaseUrl():String
    {
        return Constants.BASE_URL
    }

    @Provides
    fun provideGson():Gson{
        return GsonBuilder()
            .setLenient()
            .create()
    }
    @Provides
    fun provideLogingInterceptor():HttpLoggingInterceptor
    {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }
    @Provides
    fun provideOkhttp(loggingInterceptor: HttpLoggingInterceptor):OkHttpClient
    {
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS) // connect timeout
            .writeTimeout(60, TimeUnit.SECONDS) // write timeout
            .readTimeout(60, TimeUnit.SECONDS) // read timeout
            .addInterceptor(loggingInterceptor)
            .build()
    }
    @Provides
    fun provideConvertFactory(gson: Gson):GsonConverterFactory
    {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun provideRXjavaFactory():RxJava2CallAdapterFactory
    {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    fun provideRetofitInstance(client: OkHttpClient,gsonConverterFactory: GsonConverterFactory,
                               rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,baseUle:String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUle)
            .client(client)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun provideApiservice(retrofit: Retrofit): ApiService
    {
        return retrofit.create(ApiService::class.java)
    }
}