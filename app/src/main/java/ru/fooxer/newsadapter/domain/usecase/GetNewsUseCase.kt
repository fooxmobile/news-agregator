package ru.fooxer.newsadapter.domain.usecase

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import ru.fooxer.newsadapter.data.repo.NewsRepositoryImpl
import ru.fooxer.newsadapter.domain.model.NewsModel
import ru.fooxer.newsadapter.domain.repository.NewsRepository
import javax.inject.Inject


/*
 * Created by fooxer on 14.10.2020
 */

class GetNewsUseCase @Inject  constructor(val apiRepo: NewsRepositoryImpl) :
UseCase<ArrayList<NewsModel>> {
    override fun execute(): Observable<ArrayList<NewsModel>> {
        // TODO: get a string to search news somehow
        return apiRepo.getNewsByName("Dragon Age")

    }

}