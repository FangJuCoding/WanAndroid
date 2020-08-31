package cn.funcoding.wanandroid.base.config

/**
 * 组件生命周期反射类名管理，在这里注册需要初始化的组件，通过反射动态调用各个组件的初始化方法
 * <p>
 * 注：以下模块中初始化的Module类不能被混淆
 */
class ModuleLifecycleReflects {
    companion object {
        private const val BaseInit = "cn.funcoding.wanandroid.base.base.BaseModuleInit"

        private const val AccountInit = "cn.funcoding.wanandroid.account.AccountModuleInit"

        private const val MainInit = "cn.funcoding.wanandroid.main.MainModuleInit"

        private const val HomeInit = "cn.funcoding.wanandroid.home.HomeModuleInit"

        private const val SystemInit = "cn.funcoding.wanandroid.system.SystemModuleInit"

        private const val FindInit = "cn.funcoding.wanandroid.find.FindModuleInit"

        private const val NavInit = "cn.funcoding.wanandroid.nav.NavModuleInit"

        private const val MineInit = "cn.funcoding.wanandroid.mine.MineModuleInit"

        val initModuleNames =
            listOf(BaseInit, AccountInit, MainInit, HomeInit, SystemInit, FindInit, NavInit, MineInit)
    }
}