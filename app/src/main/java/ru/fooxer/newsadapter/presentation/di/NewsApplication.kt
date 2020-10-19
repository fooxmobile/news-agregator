package ru.fooxer.newsadapter.presentation.di

import android.app.Application
import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.fooxer.newsadapter.presentation.di.AppComponent
import ru.fooxer.newsadapter.presentation.di.DaggerAppComponent


/*
 * Created by fooxer on 14.10.2020
 */

class NewsApplication : Application(){

     var component: AppComponent = DaggerAppComponent.create()


   /* override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        component = DaggerAppComponent.builder()
            .application(this)
            .build()
        return component
    }

    */




}