package com.funcoding.wanandroid.main

import com.alibaba.android.arouter.facade.annotation.Route
import com.funcoding.wanandroid.base.base.BaseActivity
import com.funcoding.wanandroid.base.router.RouterPath

@Route(path = RouterPath.PAGER_MAIN)
class MainActivity : BaseActivity() {

    override fun getLayoutResId(): Int = R.layout.main_activity
}
