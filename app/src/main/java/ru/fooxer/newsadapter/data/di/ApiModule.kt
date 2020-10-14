package ru.fooxer.newsadapter.data.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.fooxer.newsadapter.data.apiservice.NewsService


/*
 * Created by fooxer on 14.10.2020
 */


@Module(includes = [NetworkModule::class])
class ApiModule {

    @Provides
    fun bindApiService(retrofit: Retrofit) : NewsService {
        return retrofit.create(NewsService::class.java)
    }
}