package com.funcoding.wanandroid.base.config

/**
 * 组件生命周期反射类名管理，在这里注册需要初始化的组件，通过反射动态调用各个组件的初始化方法
 * <p>
 * 注：以下模块中初始化的Module类不能被混淆
 */
class ModuleLifecycleReflects {
    companion object {
        private const val BaseInit = "com.funcoding.wanandroid.base.base.BaseModuleInit"

        private const val SignInit = "com.funcoding.wanandroid.sign.SignModuleInit"

        val initModuleNames = listOf(BaseInit, SignInit)
    }
}