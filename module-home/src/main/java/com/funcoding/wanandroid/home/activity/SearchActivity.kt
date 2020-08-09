package com.funcoding.wanandroid.home.activity

import android.content.Context
import android.content.Intent
import com.funcoding.wanandroid.base.base.BaseActivity
import com.funcoding.wanandroid.home.R

/**
 * 搜索界面
 */
class SearchActivity : BaseActivity() {
    override fun getLayoutResId(): Int = R.layout.home_search_activity

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, SearchActivity::class.java))
        }
    }
}