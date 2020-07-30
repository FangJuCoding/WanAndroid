package com.funcoding.wanandroid.user.user

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.funcoding.wanandroid.user.R

/**
 * 登陆注册相关界面
 */
class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_account_activity)
    }

    companion object {
        fun gotoAccountActivity(context: Context) {
            context.startActivity(Intent(context, AccountActivity::class.java))
        }
    }
}