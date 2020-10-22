package ru.fooxer.newsadapter.presentation

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import ru.fooxer.newsadapter.domain.usecase.GetNewsUseCase
import ru.fooxer.newsadapter.presentation.ui.MainView
import ru.fooxer.newsadapter.utils.SchedulerProvider
import java.util.concurrent.TimeUnit
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

    fun checkConnection() {
        // TODO Check Internet Connection
    }

    fun fetchNews() {
        useCase.execute()
            .subscribeOn(schedulers.io())
            .delay(5000, TimeUnit.MILLISECONDS)
            .doOnSubscribe {
                // show loading wheel
                view?.hideRecycler()
                view?.hideError()
                view?.showProgressBar()
                 }
            .map {
                Log.d("M_MainPresenter:", "CurrentThread: ${Thread.currentThread().name}")
                it
            }
            .observeOn(schedulers.ui())
            .doOnNext{
                Log.d("M_MainPresenter:", "onNext!")
                Log.d("M_MainPresenter:", "News were found:${it.size}")
                Log.d("M_MainPresenter:", "CurrentThread: ${Thread.currentThread().name}")
                view?.hideProgressBar()
                view?.showRecycler()
                view?.updateAdapter(it)
            }
            .doOnError{ Log.d("M_MainPresenter:", "onError! ${it.stackTrace}")
                view?.hideRecycler()
                view?.showError()
            }
            .doOnComplete {
                Log.d("M_MainPresenter:", "onComplete!")
            }
            .subscribe()



    }



}