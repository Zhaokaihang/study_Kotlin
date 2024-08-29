package com.example.baselin

import androidx.appcompat.app.AppCompatActivity

abstract class BaseMainActivity : AppCompatActivity(), BaseView {

    var mPresenter: BasePresenter<*>? = null

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.onDestroy()
    }
}