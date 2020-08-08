package com.funcoding.wanandroid.system

import com.alibaba.android.arouter.facade.annotation.Route
import com.funcoding.wanandroid.base.base.BaseFragment
import com.funcoding.wanandroid.base.router.RouterPath

/**
 * 体系页面
 */
@Route(path = RouterPath.PAGER_SYSTEM)
class SystemFragment:BaseFragment() {
    override fun getLayResId(): Int = R.layout.system_fragment
}