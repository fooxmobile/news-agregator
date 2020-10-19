package ru.fooxer.newsadapter.presentation.ui

import ru.fooxer.newsadapter.domain.model.NewsModel

interface MainView {

    fun initRecyclerView()
    fun showError()
    fun hideError()
    fun showRecycler()
    fun hideRecycler()
    fun fetch()
    fun showProgressBar()
    fun hideProgressBar()
    fun setRecyclerAdapter(items: ArrayList<NewsModel>)
    fun updateRecycler()
}