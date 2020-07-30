package com.funcoding.wanandroid.user.launcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.funcoding.wanandroid.base.utils.MainHandler
import com.funcoding.wanandroid.user.R
import com.funcoding.wanandroid.user.login.LoginActivity

/**
 * 启动页面
 */
class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_launcher_activity)

        MainHandler.postDelay(Runnable {
            toSign()
        },
            DELAY_MILLIS
        )
    }

    private fun toSign() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun onBackPressed() {

    }

    companion object {
        private const val DELAY_MILLIS = 1000L
    }
}