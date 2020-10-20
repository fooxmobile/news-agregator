package ru.fooxer.newsadapter.data.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import ru.fooxer.newsadapter.ApplicationConfig

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        Log.d("M_ApiKeyInterceptor:", "Build interceptor")
        val url = request.url.newBuilder()
            .addQueryParameter("apiKey", ApplicationConfig.NEWS_API_KEY)
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}