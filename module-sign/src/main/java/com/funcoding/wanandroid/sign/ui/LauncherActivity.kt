package com.funcoding.wanandroid.sign.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.funcoding.wanandroid.base.utils.MainHandler
import com.funcoding.wanandroid.sign.R

class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_launcher_activity)

        MainHandler.postDelay(Runnable {
            toSign()
        }, 500)
    }

    private fun toSign() {
        startActivity(Intent(this, SignActivity::class.java))
    }
}