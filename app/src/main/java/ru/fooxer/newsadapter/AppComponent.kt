package ru.fooxer.newsadapter

import dagger.Component
import ru.fooxer.newsadapter.data.di.ApiModule
import ru.fooxer.newsadapter.data.di.NetworkModule


@Component (modules = [
NetworkModule::class,
ApiModule::class
])
interface AppComponent {
}