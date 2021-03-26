package com.devtak.watcha.core

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

fun provideRetrofit(okHttpClient: OkHttpClient? = null, baseURL: String): Retrofit {
    val client = okHttpClient
        ?: OkHttpClient.Builder()
            .readTimeout(5, TimeUnit.SECONDS)
            .build()

    return Retrofit.Builder()
        .baseUrl(baseURL)
        .client(client)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
