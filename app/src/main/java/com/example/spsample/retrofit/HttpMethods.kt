package com.example.spsample.retrofit

import android.app.Activity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object HttpMethods {
    var retrofit: Retrofit? = null
    var commonService: CommonService? = null

    init {
        // 初始化
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.oioweb.cn/api/common/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            //设置超时
            .client(OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).build())
            .build()
        commonService = retrofit?.create(CommonService::class.java)
    }

    fun getTopMovie(activity: Activity, sub: Observer<Bean>) {
        commonService!!.getTopMovie()
            // 设置任务工作线程
            .subscribeOn(Schedulers.io())
            // 设置清理资源线程
            .unsubscribeOn(Schedulers.io())
            //设置observer回调线程
            .observeOn(AndroidSchedulers.mainThread())
            //开始订阅
            .subscribe(sub)
    }


}