package ru.fooxer.newsadapter.presentation.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.fooxer.newsadapter.domain.usecase.GetNewsUseCase
import ru.fooxer.newsadapter.presentation.MainPresenter
import ru.fooxer.newsadapter.presentation.Presenter
import ru.fooxer.newsadapter.utils.SchedulerFacade
import ru.fooxer.newsadapter.utils.SchedulerProvider


/*
 * Created by fooxer on 19.10.2020
 */

@Module
abstract class PresenterModule {
    @Binds
    abstract fun bindMainPresenter(presenter: MainPresenter): Presenter
}