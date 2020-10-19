package ru.fooxer.newsadapter.presentation.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.fooxer.newsadapter.data.di.ApiModule
import ru.fooxer.newsadapter.data.di.NetworkModule
import ru.fooxer.newsadapter.presentation.ui.MainActivity
import javax.inject.Singleton

@Singleton
@Component (modules = [
NetworkModule::class,
ApiModule::class,
AppModule::class,
PresenterModule::class,
ActivityBindingModule::class,
AndroidInjectionModule::class
])
interface AppComponent : AndroidInjector<NewsApplication> {

    fun inject(activity: MainActivity)

  /*  @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

   */

}