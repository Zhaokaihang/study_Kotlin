package com.example.spsample.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fraga: FragmentActivity, var fraglist: ArrayList<Fragment>) :
    FragmentStateAdapter(fraga) {

    override fun getItemCount(): Int {
        return fraglist.size
    }

    override fun createFragment(position: Int): Fragment {
        return fraglist.get(position)
    }


}