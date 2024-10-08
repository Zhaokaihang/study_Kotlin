package com.example.spsample

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.baselin.BaseMainActivity
import com.example.spsample.fragment.OneFragment
import com.example.spsample.fragment.TwoFragment
import com.example.spsample.fragment.ViewPagerAdapter
import com.example.spsample.retrofit.Bean
import com.example.spsample.retrofit.HttpMethods
import com.example.spsample.retrofit.ProgressSub
import com.google.android.material.tabs.TabLayout

class MainActivity : BaseMainActivity() {
    var vp: ViewPager2? = null
    var tl: TabLayout? = null
    val fragmentList: ArrayList<Fragment> by lazy { ArrayList() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initView()
        initData()
    }

    override fun initView() {
        vp = findViewById(R.id.vp)
        tl = findViewById(R.id.tl)
    }

    override fun initData() {
        fragmentList.add(OneFragment())
        fragmentList.add(TwoFragment())
        val viewPagerAdapter = ViewPagerAdapter(this, fragmentList)
        vp?.adapter = viewPagerAdapter;

    }

    fun getData() {
        HttpMethods.getTopMovie(this, object : ProgressSub<Bean>(this) {
            override fun onNext(t: Bean) {
                Log.d("zkhlog", "加载成功数据：$t")
            }
        })
    }
}