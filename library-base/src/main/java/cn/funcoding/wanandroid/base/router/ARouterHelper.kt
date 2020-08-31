package cn.funcoding.wanandroid.base.router

import com.alibaba.android.arouter.launcher.ARouter
import cn.funcoding.wanandroid.base.R
import cn.funcoding.wanandroid.base.base.AppContext
import cn.funcoding.wanandroid.base.router.callback.LoginNavigationCallback

object ARouterHelper {
    private val ROUTER by lazy { ARouter.getInstance() }

    fun navWithLoginInterceptorCallback(path: String) {
        ROUTER.build(path).navigation(AppContext, LoginNavigationCallback())
    }

    fun navigation(path: String) {
        ROUTER.build(path).navigation()
    }

    fun greenChannelNavigation(path: String) {
        ROUTER.build(path).greenChannel()
            .withTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
            .navigation()
    }
}