package com.funcoding.wanandroid.mine

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.funcoding.wanandroid.base.base.BaseFragment
import com.funcoding.wanandroid.base.router.ARouterHelper
import com.funcoding.wanandroid.base.router.RouterPath
import kotlinx.android.synthetic.main.mine_fragment.*

/**
 * 我的页面
 */
@Route(path = RouterPath.PAGER_FRAGMENT_MINE)
class MineFragment : BaseFragment() {
    override fun getLayResId(): Int = R.layout.mine_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}