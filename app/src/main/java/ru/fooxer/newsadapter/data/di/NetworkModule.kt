package ru.fooxer.newsadapter.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.fooxer.newsadapter.ApplicationConfig
import ru.fooxer.newsadapter.data.interceptor.ApiKeyInterceptor
import javax.inject.Singleton


/*
 * Created by fooxer on 14.10.2020
 */
@Module
class NetworkModule {
    @Provides
    fun provideOkHttpClient() : OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
        okHttpBuilder.addInterceptor(ApiKeyInterceptor())
        return okHttpBuilder.build()
    }

    @Singleton
    @Provides
    fun provideGson() : Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApplicationConfig.NEWS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }
}