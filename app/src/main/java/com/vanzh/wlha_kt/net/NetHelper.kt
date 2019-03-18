package com.vanzh.wlha_kt.net

import com.vanzh.dialogdemo.net.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * created by zp on 2019/3/18.
 */

class NetHelper {

    val BASE_URL = "https://api.j1home.com/api/"

    companion object {
        val getInstance: ApiService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            val netHelper = NetHelper()
            netHelper.initClient()
        }
    }


    private fun initClient(): ApiService {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkhttp())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
    }

    private fun getOkhttp(): OkHttpClient {
        return OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .addInterceptor(LogInterceptor())
                .build()
    }
}