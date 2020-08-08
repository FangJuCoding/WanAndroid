package com.funcoding.wanandroid.find

import android.app.Application
import com.funcoding.wanandroid.base.base.BaseModuleInit
import com.funcoding.wanandroid.base.utils.WLog

/**
 * 发现模块初始化
 */
class FindModuleInit : BaseModuleInit() {
    override fun onInitAhead(application: Application): Boolean {
        WLog.info("FindModuleInit onInitAhead")
        return false
    }

    override fun onInitLow(application: Application): Boolean {
        WLog.info("FindModuleInit onInitLow")
        return false
    }
}