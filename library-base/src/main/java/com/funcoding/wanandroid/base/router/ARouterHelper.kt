package com.funcoding.wanandroid.base.router

import com.alibaba.android.arouter.launcher.ARouter
import com.funcoding.wanandroid.base.base.AppContext
import com.funcoding.wanandroid.base.router.callback.LoginNavigationCallback

object ARouterHelper {

    fun navWithLoginInterceptorCallback(path: String) {
        ARouter.getInstance().build(path).navigation(AppContext, LoginNavigationCallback())
    }

    fun navigation(path: String) {
        ARouter.getInstance().build(path).navigation()
    }
}