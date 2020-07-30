package com.funcoding.wanandroid.sign.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.funcoding.wanandroid.base.router.RouterPath
import com.funcoding.wanandroid.sign.R

@Route(path = RouterPath.ActivityPath.PAGER_SIGN)
class SignActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_activity)
    }
}
