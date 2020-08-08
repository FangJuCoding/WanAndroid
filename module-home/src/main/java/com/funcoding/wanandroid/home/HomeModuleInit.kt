package com.funcoding.wanandroid.home

import android.app.Application
import com.funcoding.wanandroid.base.base.BaseModuleInit
import com.funcoding.wanandroid.base.utils.WLog

/**
 * 首页模块初始化
 */
class HomeModuleInit : BaseModuleInit() {
    override fun onInitAhead(application: Application): Boolean {
        WLog.info("HomeModuleInit onInitAhead")
        return false
    }

    override fun onInitLow(application: Application): Boolean {
        WLog.info("HomeModuleInit onInitLow")
        return false
    }
}