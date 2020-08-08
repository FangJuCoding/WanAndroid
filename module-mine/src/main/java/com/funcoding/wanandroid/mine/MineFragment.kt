package com.funcoding.wanandroid.mine

import com.alibaba.android.arouter.facade.annotation.Route
import com.funcoding.wanandroid.base.base.BaseFragment
import com.funcoding.wanandroid.base.router.RouterPath

/**
 * 我的页面
 */
@Route(path = RouterPath.PAGER_FRAGMENT_MINE)
class MineFragment : BaseFragment() {
    override fun getLayResId(): Int = R.layout.mine_fragment
}