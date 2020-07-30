package com.funcoding.wanandroid.sign.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.funcoding.wanandroid.base.utils.MainHandler
import com.funcoding.wanandroid.sign.R
import kotlinx.android.synthetic.main.sign_launcher_activity.*

/**
 * 启动页面
 */
class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_launcher_activity)

        MainHandler.postDelay(Runnable {
            toSign()
        }, DELAY_MILLIS)
    }

    private fun toSign() {
        startActivity(Intent(this, SignActivity::class.java))
        finish()
    }

    override fun onBackPressed() {

    }

    companion object {
        private const val DELAY_MILLIS = 1000L
    }
}