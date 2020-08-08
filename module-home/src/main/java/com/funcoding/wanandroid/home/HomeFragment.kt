package com.funcoding.wanandroid.home

import com.alibaba.android.arouter.facade.annotation.Route
import com.funcoding.wanandroid.base.base.BaseFragment
import com.funcoding.wanandroid.base.router.RouterPath

/**
 * 首页
 */
@Route(path = RouterPath.PAGER_FRAGMENT_HOME)
class HomeFragment : BaseFragment() {
    override fun getLayResId(): Int = R.layout.home_fragment
}