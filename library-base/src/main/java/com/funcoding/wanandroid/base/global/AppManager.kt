package com.funcoding.wanandroid.base.global

import android.os.Process

object AppManager {
    fun exitApp() {
        Process.killProcess(Process.myPid())
    }
}