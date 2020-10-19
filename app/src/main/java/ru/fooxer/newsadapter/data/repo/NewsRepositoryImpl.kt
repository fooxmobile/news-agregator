package ru.fooxer.newsadapter.data.repo

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import ru.fooxer.newsadapter.data.apiservice.ApiService
import ru.fooxer.newsadapter.data.apiservice.NewsService
import ru.fooxer.newsadapter.data.mapper.NewsMapper
import ru.fooxer.newsadapter.domain.repository.NewsRepository
import ru.fooxer.newsadapter.domain.model.NewsModel
import javax.inject.Inject


/*
 * Created by fooxer on 12.10.2020
 */

class NewsRepositoryImpl @Inject constructor(
    private val apiService: NewsService,
    private val newsMapper: dagger.Lazy<NewsMapper>
) : NewsRepository  {
    override fun getNewsByName(name: String): Observable<ArrayList<NewsModel>> {
        return apiService.getNewsByName(name)
            .map{
                newsMapper.get().toNews(it.articles)
            }
    }

}
