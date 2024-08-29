package com.example.spsample

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.baselin.BaseMainActivity
import com.example.spsample.retrofit.Bean
import com.example.spsample.retrofit.HttpMethods
import com.example.spsample.retrofit.ProgressSub

class MainActivity : BaseMainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getData()
    }

    fun getData() {
        HttpMethods.getTopMovie(this, object : ProgressSub<Bean>(this) {
            override fun onNext(t: Bean) {
                Log.d("zkhlog", "加载成功数据：$t")
            }
        })
    }
}