package com.jzarsuelo.android.sunshine.view.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jzarsuelo.android.sunshine.R
import com.jzarsuelo.android.sunshine.app.Injection
import com.jzarsuelo.android.sunshine.data.Forecast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(mainToolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""
        supportActionBar?.setLogo(R.drawable.ic_logo)

        presenter.onRequestData()
    }

    override var presenter: MainContract.Presenter = MainPresenter(this, Injection.forecastRepository())

    override fun showData(data: List<Forecast>) {

        val adapter = ForecastAdapter()
        adapter.add(data)

        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter

        progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }
}
