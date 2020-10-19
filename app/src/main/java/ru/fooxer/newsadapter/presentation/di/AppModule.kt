package ru.fooxer.newsadapter.presentation.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import ru.fooxer.newsadapter.utils.SchedulerFacade
import ru.fooxer.newsadapter.utils.SchedulerProvider


/*
 * Created by fooxer on 18.10.2020
 */

@Module
abstract class AppModule {
    @Binds
    abstract fun bindContext(application: Application): Context
    @Binds
    abstract fun bindProviderScheduler(schedulerFacade: SchedulerFacade): SchedulerProvider
}