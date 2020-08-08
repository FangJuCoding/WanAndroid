package com.funcoding.wanandroid.nav

import com.alibaba.android.arouter.facade.annotation.Route
import com.funcoding.wanandroid.base.base.BaseFragment
import com.funcoding.wanandroid.base.router.RouterPath

/**
 * 导航页面
 */
@Route(path = RouterPath.PAGER_NAVIGATION)
class NavFragment : BaseFragment() {
    override fun getLayResId(): Int = R.layout.nav_fragment
}