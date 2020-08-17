package com.funcoding.wanandroid.base.router

object RouterPath {
    // 登陆和注册页面
    private const val GROUP_ACCOUNT = "/account"
    const val PAGER_ACTIVITY_ACCOUNT = "$GROUP_ACCOUNT/Account"

    // 主页面
    private const val GROUP_MAIN = "/main"
    const val PAGER_ACTIVITY_MAIN = "$GROUP_MAIN/Main"

    // 搜索界面
    private const val GROUP_SEARCH = "/search"
    const val PAGER_ACTIVITY_SEARCH = "$GROUP_SEARCH/Search"

    // 首页
    private const val GROUP_HOME = "/home"
    const val PAGER_FRAGMENT_HOME = "$GROUP_HOME/Home"

    // 体系页面
    private const val GROUP_SYSTEM = "/system"
    const val PAGER_FRAGMENT_SYSTEM = "$GROUP_SYSTEM/System"

    // 发现页面
    private const val GROUP_FIND = "/find"
    const val PAGER_FRAGMENT_FIND = "$GROUP_FIND/Find"

    // 导航页面
    private const val GROUP_NAV = "/nav"
    const val PAGER_FRAGMENT_NAVIGATION = "$GROUP_NAV/Navigation"

    // 我的页面
    private const val GROUP_MINE = "/mine"
    const val PAGER_FRAGMENT_MINE = "$GROUP_MINE/Mine"

    // 我的积分页面
    private const val GROUP_INTEGRAL_RECORD = "/integralRecord"
    const val PAGER_ACTIVITY_INTEGRAL_RECORD = "$GROUP_INTEGRAL_RECORD/IntegralRecord"

    // 积分排行榜页面
    private const val GROUP_INTEGRAL_RANK = "/integralRank"
    const val PAGER_ACTIVITY_INTEGRAL_RANK = "$GROUP_INTEGRAL_RANK/IntegralRank"
}