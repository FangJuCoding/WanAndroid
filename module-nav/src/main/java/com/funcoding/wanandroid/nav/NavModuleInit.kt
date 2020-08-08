package com.funcoding.wanandroid.nav

import android.app.Application
import com.funcoding.wanandroid.base.base.BaseModuleInit
import com.funcoding.wanandroid.base.utils.WLog

/**
 * 导航模块初始化
 */
class NavModuleInit : BaseModuleInit() {
    override fun onInitAhead(application: Application): Boolean {
        WLog.info("NavModuleInit onInitAhead")
        return false
    }

    override fun onInitLow(application: Application): Boolean {
        WLog.info("NavModuleInit onInitLow")
        return false
    }
}