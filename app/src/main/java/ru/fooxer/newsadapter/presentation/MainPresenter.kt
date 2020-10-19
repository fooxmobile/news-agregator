package ru.fooxer.newsadapter.presentation

import android.util.Log
import ru.fooxer.newsadapter.domain.usecase.GetNewsUseCase
import ru.fooxer.newsadapter.presentation.ui.MainView
import ru.fooxer.newsadapter.utils.SchedulerProvider
import javax.inject.Inject


/*
 * Created by fooxer on 11.10.2020
 */

class MainPresenter @Inject constructor(
    val useCase: GetNewsUseCase,
    val schedulers: SchedulerProvider,
    ) : Presenter {

    private var view: MainView? = null


    fun setView(v: MainView) {
        view = v
    }

    fun onViewDestroyed() {
        view = null
    }

    fun fetchNews() {
        useCase.execute()
            .subscribeOn(schedulers.io())
            .doOnSubscribe {
                // show loading wheel
                view?.hideRecycler()
                view?.hideError()
                view?.showProgressBar()
                 }
            .doOnNext{
                Log.d("M_MainPresenter:", "onNext!")
            }
            .doOnError{ Log.d("M_MainPresenter:", "onError! ${it.stackTrace}")}
            .doOnComplete {

                Log.d("M_MainPresenter:", "onComplete!")  }
            .subscribe()



    }



}