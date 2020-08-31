package cn.funcoding.wanandroid.base.base

import android.app.Application
import android.content.ContextWrapper

private lateinit var INSTANCE: Application

open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}

object AppContext : ContextWrapper(INSTANCE)