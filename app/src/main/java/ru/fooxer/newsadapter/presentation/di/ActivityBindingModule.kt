package ru.fooxer.newsadapter.presentation.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.fooxer.newsadapter.presentation.ui.MainActivity


@Module(includes = [PresenterModule::class])
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity() : MainActivity
}