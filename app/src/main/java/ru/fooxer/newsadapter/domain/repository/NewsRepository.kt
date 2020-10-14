package ru.fooxer.newsadapter.domain.repository

import io.reactivex.rxjava3.core.Observable
import ru.fooxer.newsadapter.domain.model.NewsModel

interface NewsRepository {

    //TODO: Add RxJava
    fun getNewsByName(name: String): Observable<ArrayList<NewsModel>>


}