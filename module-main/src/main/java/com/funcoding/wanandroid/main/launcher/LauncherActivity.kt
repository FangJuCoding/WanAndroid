package com.funcoding.wanandroid.main.launcher

import android.os.Bundle
import com.funcoding.wanandroid.base.base.BaseActivity
import com.funcoding.wanandroid.base.router.ARouterHelper
import com.funcoding.wanandroid.base.router.RouterPath
import com.funcoding.wanandroid.base.utils.MainHandler
import com.funcoding.wanandroid.main.R

/**
 * 启动页面
 */
class LauncherActivity : BaseActivity() {

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        MainHandler.postDelay(
            Runnable {
                gotoMain()
            },
            DELAY_MILLIS
        )
    }

    override fun getLayoutResId(): Int = R.layout.main_launcher_activity

    private fun gotoMain() {
        ARouterHelper.greenChannelNavigation(RouterPath.PAGER_ACTIVITY_MAIN)
        finish()
    }

    override fun onBackPressed() {

    }

    companion object {
        private const val DELAY_MILLIS = 1000L
    }
}