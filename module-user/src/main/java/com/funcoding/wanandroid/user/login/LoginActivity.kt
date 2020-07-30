package com.funcoding.wanandroid.user.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.funcoding.wanandroid.base.router.RouterPath
import com.funcoding.wanandroid.user.R

/**
 * 登陆页面
 */
@Route(path = RouterPath.ActivityPath.PAGER_SIGN)
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_login_activity)
    }
}
