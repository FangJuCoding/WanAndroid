package cn.funcoding.wanandroid

import androidx.multidex.MultiDex
import cn.funcoding.wanandroid.base.base.BaseApplication
import cn.funcoding.wanandroid.base.config.ModuleLifecycleConfig

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