package com.mandatoryfun.harrybartlam.data.api

import com.mandatoryfun.harrybartlam.data.BuildConfig
import com.mandatoryfun.harrybartlam.data.model.ApiAssets
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PolyService {
    @GET("${BuildConfig.BASE_API_VERSION}/assets")
    fun getResources(@Query("pageSize") pageSize: Int = 100,
                     @Query("keywords") keywords: String,
                     @Query("format") format: String = "OBJ",
                     @Query("key") key: String = BuildConfig.API_KEY_POLY): Single<ApiAssets>
}