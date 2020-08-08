package com.funcoding.wanandroid.find

import com.alibaba.android.arouter.facade.annotation.Route
import com.funcoding.wanandroid.base.base.BaseFragment
import com.funcoding.wanandroid.base.router.RouterPath

/**
 * 发现页
 */
@Route(path = RouterPath.PAGER_FIND)
class FindFragment : BaseFragment() {
    override fun getLayResId(): Int = R.layout.find_fragment
}