package com.mandatoryfun.harrybartlam.arch

import com.mandatoryfun.harrybartlam.data.BuildConfig
import com.mandatoryfun.harrybartlam.data.api.PolyService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiModule {

    val polyService by lazy {
        retrofit.create(PolyService::class.java)
    }

    private val retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
    }

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
                .addNetworkInterceptor { chain ->
                    val request = chain.request().newBuilder()
                            .addHeader("Content-Type", "application/json")
                            .build()
                    chain.proceed(request)
                }
                .build()
    }
}
