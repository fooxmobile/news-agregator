package ru.fooxer.newsadapter.domain.usecase

import io.reactivex.rxjava3.core.Observable
import ru.fooxer.newsadapter.domain.model.NewsModel
import ru.fooxer.newsadapter.domain.repository.NewsRepository
import javax.inject.Inject


/*
 * Created by fooxer on 14.10.2020
 */

class GetNewsUseCase @Inject  constructor(val apiRepo: NewsRepository) :
UseCase<ArrayList<NewsModel>> {
    override fun execute(): Observable<ArrayList<NewsModel>> {
        return apiRepo.getNewsByName("Dragon Age")
    }

}