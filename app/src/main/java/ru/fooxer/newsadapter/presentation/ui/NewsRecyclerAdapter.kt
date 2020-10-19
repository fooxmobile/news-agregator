package ru.fooxer.newsadapter.presentation.ui

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.fooxer.newsadapter.R
import ru.fooxer.newsadapter.domain.model.NewsModel
import ru.fooxer.newsadapter.utils.inflate


/*
 * Created by fooxer on 14.10.2020
 */

class NewsRecyclerAdapter(private val items: ArrayList<NewsModel>) : RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder>() {



    class ViewHolder(val v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private lateinit var news: NewsModel

        private lateinit var tvTitle: TextView
        private lateinit var tvDescr: TextView
        private lateinit var ivImg: ImageView
        override fun onClick(v: View?) {
            TODO("Open link via browser and handle errors")
        }

        init {
            tvTitle = v.findViewById(R.id.tv_title_news)
            tvDescr = v.findViewById(R.id.tv_descr_news)
            ivImg = v.findViewById(R.id.iv_news)
        }
        fun bindView(news: NewsModel) {
            this.news = news
            tvTitle.text = news.title
            tvDescr.text = news.description
            Picasso.get()
                .load(news.urlToImage)
                .into(ivImg)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = parent.inflate(R.layout.item_news, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemNews = items.get(position)
        holder.bindView(itemNews)
    }

    override fun getItemCount(): Int = items.size


}