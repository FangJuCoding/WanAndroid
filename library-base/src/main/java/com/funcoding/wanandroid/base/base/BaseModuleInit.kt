package com.funcoding.wanandroid.base.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.funcoding.wanandroid.base.BuildConfig
import com.funcoding.wanandroid.base.utils.WLog

open class BaseModuleInit : IModuleInit {
    override fun onInitAhead(application: Application): Boolean {
        // 开启打印日志
        WLog.init(true)

        // 初始化阿里路由框架
        if (BuildConfig.DEBUG) {
            ARouter.openDebug()
            ARouter.openLog()
        }
        ARouter.init(application)

        WLog.info("BaseModule onInitAhead")
        return false
    }

    override fun onInitLow(application: Application): Boolean {
        WLog.info("BaseModule onInitLow")
        return false
    }

}