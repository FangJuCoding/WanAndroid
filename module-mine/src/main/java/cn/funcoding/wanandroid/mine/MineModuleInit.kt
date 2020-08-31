package cn.funcoding.wanandroid.mine

import android.app.Application
import cn.funcoding.wanandroid.base.base.BaseModuleInit
import cn.funcoding.wanandroid.base.utils.WLog

/**
 * 我的模块初始化
 */
class MineModuleInit : BaseModuleInit() {
    override fun onInitAhead(application: Application): Boolean {
        WLog.info("MineModuleInit onInitAhead")
        return false
    }

    override fun onInitLow(application: Application): Boolean {
        WLog.info("MineModuleInit onInitLow")
        return false
    }
}