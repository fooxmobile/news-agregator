package ru.fooxer.newsadapter.data.apiservice

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.fooxer.newsadapter.data.models.NewsResponse

public interface NewsService : ApiService {
    @GET("everything")
    fun getNewsByName(@Query("q") queryName: String) : /*Call<List<News>>*/ Observable<NewsResponse>
}