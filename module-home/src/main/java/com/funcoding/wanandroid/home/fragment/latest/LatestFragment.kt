package com.funcoding.wanandroid.home.fragment.latest

import com.funcoding.wanandroid.base.base.BaseFragment
import com.funcoding.wanandroid.home.R

/**
 * 最新页面
 */
class LatestFragment : BaseFragment() {

    companion object{
        fun newInstance() = LatestFragment()
    }

    override fun getLayResId(): Int = R.layout.home_latest_fragment
}