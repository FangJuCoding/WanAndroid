package com.funcoding.wanandroid.user.launcher

import com.funcoding.wanandroid.base.base.BaseActivity
import com.funcoding.wanandroid.base.utils.MainHandler
import com.funcoding.wanandroid.user.R
import com.funcoding.wanandroid.user.account.AccountActivity

/**
 * 启动页面
 */
class LauncherActivity : BaseActivity() {

    override fun initView() {
        super.initView()
        MainHandler.postDelay(
            Runnable {
                gotoMain()
            },
            DELAY_MILLIS
        )
    }

    override fun getLayoutResId(): Int = R.layout.user_launcher_activity

    private fun gotoMain() {
        AccountActivity.gotoAccountActivity(this)
        finish()
    }

    override fun onBackPressed() {

    }

    companion object {
        private const val DELAY_MILLIS = 1000L
    }
}