package ru.fooxer.newsadapter.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.fooxer.newsadapter.R

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvNews)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager


    }

    override fun initRecyclerView() {

    }
}