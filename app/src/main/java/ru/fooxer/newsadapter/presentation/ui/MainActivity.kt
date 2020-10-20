package ru.fooxer.newsadapter.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.AndroidInjection.inject
import ru.fooxer.newsadapter.R
import ru.fooxer.newsadapter.domain.model.NewsModel
import ru.fooxer.newsadapter.presentation.MainPresenter
import ru.fooxer.newsadapter.presentation.di.DaggerAppComponent
import ru.fooxer.newsadapter.presentation.di.NewsApplication
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var tvError: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: NewsRecyclerAdapter

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as NewsApplication).component.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvNews)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager


        tvError = findViewById(R.id.tv_error)
        progressBar = findViewById(R.id.progressBar)


        setRecyclerAdapter(ArrayList<NewsModel>())
        initRecyclerView()
        mainPresenter.setView(this)



    }

    override fun onStart() {
        super.onStart()
        fetch()
    }

    override fun fetch() {
        mainPresenter.fetchNews()
    }

    override fun updateAdapter(items: ArrayList<NewsModel>) {
        adapter.items = items
        updateRecycler()
    }

    override fun initRecyclerView() {
        recyclerView.adapter = adapter
    }

    override fun showError() {
        tvError.visibility = View.VISIBLE
    }

    override fun hideError() {
        tvError.visibility = View.INVISIBLE
    }

    override fun showRecycler() {
        recyclerView.visibility = View.VISIBLE
    }

    override fun hideRecycler() {
       recyclerView.visibility = View.INVISIBLE
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun setRecyclerAdapter(items: ArrayList<NewsModel>) {
        adapter = NewsRecyclerAdapter(items)

    }

    override fun updateRecycler() {
        adapter.notifyDataSetChanged()
    }
}