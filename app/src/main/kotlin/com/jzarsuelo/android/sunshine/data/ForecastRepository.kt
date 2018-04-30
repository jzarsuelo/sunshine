package com.jzarsuelo.android.sunshine.data

class ForecastRepository(
        private val remoteDataSource: ForecastDataSource
) : ForecastDataSource {

    override fun requestData(city: String, days: Int, callback: ForecastDataSource.ForecastsCallback) {
        remoteDataSource.requestData(city, days, callback)
    }

    companion object {
        private var instance: ForecastRepository? = null

        fun getInstance(remoteDataSource: ForecastDataSource) : ForecastRepository {
            return instance ?: ForecastRepository(remoteDataSource).apply { instance = this }
        }
    }
}