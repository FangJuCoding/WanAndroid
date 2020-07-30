package com.funcoding.wanandroid.base.config

import android.app.Application
import androidx.annotation.NonNull
import com.funcoding.wanandroid.base.base.IModuleInit

/**
 * 作为组件生命周期初始化的配置类，通过反射机制，动态调用每个组件初始化逻辑
 */
object ModuleLifecycleConfig {
    fun initModuleAhead(@NonNull application: Application) {
        for (initModuleName in ModuleLifecycleReflects.initModuleNames) {
            val clazz: Class<*> = Class.forName(initModuleName)
            val moduleInit: IModuleInit = clazz.newInstance() as IModuleInit
            moduleInit.onInitAhead(application)
        }
    }

    fun initModuleLow(@NonNull application: Application) {
        for (initModuleName in ModuleLifecycleReflects.initModuleNames) {
            val clazz: Class<*> = Class.forName(initModuleName)
            val moduleInit: IModuleInit = clazz.newInstance() as IModuleInit
            moduleInit.onInitLow(application)
        }
    }
}