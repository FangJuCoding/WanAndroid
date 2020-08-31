package cn.funcoding.wanandroid.account

import android.app.Application
import cn.funcoding.wanandroid.base.base.BaseModuleInit
import cn.funcoding.wanandroid.base.utils.WLog

/**
 * 用户模块初始化
 */
class AccountModuleInit : BaseModuleInit() {
    override fun onInitAhead(application: Application): Boolean {
        WLog.info("AccountModuleInit onInitAhead")
        return false
    }

    override fun onInitLow(application: Application): Boolean {
        WLog.info("AccountModuleInit onInitLow")
        return false
    }
}