package com.funcoding.wanandroid.base.router

object RouterPath {
    // 登陆和注册页面
    private const val GROUP_ACCOUNT = "/account"
    const val PAGER_LOGIN = "$GROUP_ACCOUNT/Login"
    const val PAGER_REGISTER = "$GROUP_ACCOUNT/Register"

    // 主页面
    private const val GROUP_MAIN = "/main"
    const val PAGER_MAIN = "$GROUP_MAIN/Main"

    // 首页
    const val PAGER_HOME = "$GROUP_MAIN/Home"

    // 体系页面
    const val PAGER_SYSTEM = "$GROUP_MAIN/System"

    // 发现页面
    const val PAGER_FIND = "$GROUP_MAIN/Find"

    // 导航页面
    const val PAGER_NAVIGATION = "$GROUP_MAIN/Navigation"

    // 我的页面
    const val PAGER_MINE = "$GROUP_MAIN/Mine"
}