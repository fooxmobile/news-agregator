package ru.fooxer.newsadapter

import android.app.Application
import dagger.android.DaggerApplication


/*
 * Created by fooxer on 14.10.2020
 */

class NewsApplication : Application(){

    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.create()
    }


}