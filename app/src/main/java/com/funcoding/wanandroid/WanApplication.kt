package com.funcoding.wanandroid

import android.app.Application
import com.funcoding.wanandroid.base.config.ModuleLifecycleConfig

class WanApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 优先初始化组件
        ModuleLifecycleConfig.initModuleAhead(this)
        // ...

        // 靠后初始化组件
        ModuleLifecycleConfig.initModuleLow(this)
    }
}