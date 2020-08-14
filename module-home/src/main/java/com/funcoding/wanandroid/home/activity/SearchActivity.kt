package com.funcoding.wanandroid.home.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.funcoding.wanandroid.base.base.BaseActivity
import com.funcoding.wanandroid.base.router.RouterPath
import com.funcoding.wanandroid.home.R

/**
 * 搜索界面
 */
@Route(path = RouterPath.PAGER_ACTIVITY_SEARCH)
class SearchActivity : BaseActivity() {
    override fun getLayoutResId(): Int = R.layout.home_search_activity
}