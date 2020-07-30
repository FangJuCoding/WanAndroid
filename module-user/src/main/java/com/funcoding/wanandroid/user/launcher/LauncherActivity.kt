package com.funcoding.wanandroid.user.launcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.funcoding.wanandroid.base.utils.MainHandler
import com.funcoding.wanandroid.user.R
import com.funcoding.wanandroid.user.user.AccountActivity

/**
 * 启动页面
 */
class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_launcher_activity)

        MainHandler.postDelay(
            Runnable {
                gotoMain()
            },
            DELAY_MILLIS
        )
    }

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