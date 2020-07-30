package com.funcoding.wanandroid.base.base

import android.app.Application

/**
 * 动态配置Application，有需要初始化的组件需要实现此接口，统一在宿主app的Application中初始化
 * <p>
 * 注：有些模块需要提前进行初始化，有些则需要靠后初始化
 */
interface IModuleInit {
    // 优先初始化
    fun onInitAhead(application: Application): Boolean

    // 靠后初始化
    fun onInitLow(application: Application): Boolean
}