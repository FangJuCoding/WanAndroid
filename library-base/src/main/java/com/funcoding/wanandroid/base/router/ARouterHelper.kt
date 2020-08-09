package com.funcoding.wanandroid.base.router

import com.alibaba.android.arouter.launcher.ARouter


object ARouterHelper {
    fun navigation(path: String) {
        ARouter.getInstance().build(path).navigation()
    }
}