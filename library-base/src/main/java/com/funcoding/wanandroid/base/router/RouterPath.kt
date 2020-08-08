package com.funcoding.wanandroid.base.router

object RouterPath {
    // 登陆和注册页面
    private const val ACCOUNT = "/account"
    const val PAGER_LOGIN = "$ACCOUNT/Login"
    const val PAGER_REGISTER = "$ACCOUNT/Register"

    // 主页面
    private const val MAIN = "/main"
    const val PAGER_MAIN = "$MAIN/Main"

    // 首页
    private const val HOME = "/home"
    const val PAGER_HOME = "$HOME/Home"

    // 体系页面
    private const val SYSTEM = "/system"
    const val PAGER_SYSTEM = "$SYSTEM/System"

    // 发现页面
    private const val FIND = "/find"
    const val PAGER_FIND = "$FIND/Find"

    // 导航页面
    private const val NAVIGATION = "/navigation"
    const val PAGER_NAVIGATION = "$NAVIGATION/Navigation"

    // 我的页面
    private const val MINE = "/mine"
    const val PAGER_MINE = "$MINE/Mine"
}