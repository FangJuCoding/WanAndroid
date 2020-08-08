package com.funcoding.wanandroid

import androidx.multidex.MultiDex
import com.funcoding.wanandroid.base.base.BaseApplication
import com.funcoding.wanandroid.base.config.ModuleLifecycleConfig

class WanApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        // 优先初始化组件
        ModuleLifecycleConfig.initModuleAhead(this)
        // ...
        MultiDex.install(this)
        // 靠后初始化组件
        ModuleLifecycleConfig.initModuleLow(this)
    }
}