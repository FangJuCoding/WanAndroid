package com.funcoding.wanandroid.sign

import android.app.Application
import com.funcoding.wanandroid.base.base.BaseModuleInit
import com.funcoding.wanandroid.base.utils.WLog

class SignModuleInit : BaseModuleInit() {
    override fun onInitAhead(application: Application): Boolean {
        WLog.info("SignModuleInit onInitAhead")
        return false
    }

    override fun onInitLow(application: Application): Boolean {
        WLog.info("SignModuleInit onInitLow")
        return false
    }
}