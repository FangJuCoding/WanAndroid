package com.funcoding.wanandroid.base.config

/**
 * 组件生命周期反射类名管理，在这里注册需要初始化的组件，通过反射动态调用各个组件的初始化方法
 * <p>
 * 注：以下模块中初始化的Module类不能被混淆
 */
class ModuleLifecycleReflects {
    companion object {
        private const val BaseInit = "com.funcoding.wanandroid.base.base.BaseModuleInit"

        private const val AccountInit = "com.funcoding.wanandroid.account.AccountModuleInit"

        private const val MainInit = "com.funcoding.wanandroid.main.MainModuleInit"

        private const val HomeInit = "com.funcoding.wanandroid.home.HomeModuleInit"

        private const val SystemInit = "com.funcoding.wanandroid.system.SystemModuleInit"

        private const val FindInit = "com.funcoding.wanandroid.find.FindModuleInit"

        private const val NavInit = "com.funcoding.wanandroid.nav.NavModuleInit"

        private const val MineInit = "com.funcoding.wanandroid.mine.MineModuleInit"

        val initModuleNames =
            listOf(BaseInit, AccountInit, MainInit, HomeInit, SystemInit, FindInit, NavInit, MineInit)
    }
}