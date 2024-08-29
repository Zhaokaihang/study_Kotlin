package com.example.spsample.retrofit

import android.app.Activity
import android.util.Log
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

abstract class ProgressSub<T : Any>(val activity: Activity) : Observer<T> {


    override fun onSubscribe(d: Disposable) {
        Log.d("zkhlog", "开始加载")
    }


    override fun onError(e: Throwable) {
        Log.d("zkhlog", "加载错误")
    }

    override fun onComplete() {
        Log.d("zkhlog", "加载完成")
    }
}