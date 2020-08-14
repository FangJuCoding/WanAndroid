package com.funcoding.wanandroid.base.router.callback

import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.funcoding.wanandroid.base.router.ARouterHelper
import com.funcoding.wanandroid.base.router.RouterPath
import com.funcoding.wanandroid.base.utils.WLog

class LoginNavigationCallback : NavigationCallback {
    override fun onLost(postcard: Postcard) {
        WLog.info("onLost", postcard.toString())
    }

    override fun onFound(postcard: Postcard) {
        WLog.info("onFound", postcard.toString())
    }

    override fun onInterrupt(postcard: Postcard) {
        WLog.info("onInterrupt", postcard.toString())
        ARouterHelper.navigation(RouterPath.PAGER_ACTIVITY_ACCOUNT)
    }

    override fun onArrival(postcard: Postcard) {
        WLog.info("onArrival", postcard.toString())
    }
}