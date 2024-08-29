package com.example.baselin


abstract class BasePresenter<T>(view: BaseView) {

    abstract fun init()
    abstract fun onDestroy()
}