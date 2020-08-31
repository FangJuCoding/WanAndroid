package cn.funcoding.wanandroid.base.utils

import android.os.Handler
import android.os.Looper

object MainHandler {
    private val mainHandler by lazy { Handler(Looper.getMainLooper()) }

    fun post(r: Runnable) {
        mainHandler.post(r)
    }

    fun postDelay(r: Runnable, delayMillis: Long) {
        mainHandler.postDelayed(r, delayMillis)
    }

    fun runInMainThread(r: Runnable) {
        if (mainHandler.looper == Looper.getMainLooper()) {
            r.run()
        } else {
            post(r)
        }
    }

    fun remove(r: Runnable) {
        mainHandler.removeCallbacks(r)
    }
}