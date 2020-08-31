package cn.funcoding.wanandroid.main

import android.app.Application
import cn.funcoding.wanandroid.base.base.BaseModuleInit
import cn.funcoding.wanandroid.base.utils.WLog

/**
 * 主功能模块初始化
 */
class MainModuleInit : BaseModuleInit() {
    override fun onInitAhead(application: Application): Boolean {
        WLog.info("MainModuleInit onInitAhead")
        return false
    }

    override fun onInitLow(application: Application): Boolean {
        WLog.info("MainModuleInit onInitLow")
        return false
    }
}