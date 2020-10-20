package ru.fooxer.newsadapter.data.mapper

import ru.fooxer.newsadapter.data.models.NewsFromJson
import ru.fooxer.newsadapter.domain.model.NewsModel
import javax.inject.Inject


/*
 * Created by fooxer on 14.10.2020
 */

/**
 * A mapper to map the ObjectFromJson to Object with necessary fields in a presentable form
 */

class NewsMapper @Inject constructor() {
    fun toNews(newsFromJson: ArrayList<NewsFromJson>): ArrayList<NewsModel> {
        val mappedArray= ArrayList<NewsModel>()
        newsFromJson.forEach {
            mappedArray.add(
                NewsModel(
                it.title,
                it.description,
                it.url,
                if (it.urlToImage.isNotBlank()) it.urlToImage else "NoUrl"
            ))
        }
        return mappedArray
    }
}