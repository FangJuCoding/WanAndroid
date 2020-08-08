package com.funcoding.wanandroid.base.utils

import android.util.Log
import java.lang.StringBuilder

object WLog {
    private const val DEFAULT_TAG = "WLog"

    private var isShowLog = false
    private var isShowStackTrace = false

    fun init(isShowLog: Boolean) {
        this.isShowLog = isShowLog
    }

    fun showStackTrace(isShowStackTrace: Boolean) {
        this.isShowStackTrace = isShowStackTrace
    }

    fun verbose(msg: Any) {
        verbose(DEFAULT_TAG, msg)
    }

    fun verbose(tag: String, msg: Any) {
        if (isShowLog) {
            printLog(Log.VERBOSE, tag, msg)
        }
    }

    fun debug(msg: Any) {
        debug(DEFAULT_TAG, msg)
    }

    fun debug(tag: String, msg: Any) {
        if (isShowLog) {
            printLog(Log.DEBUG, tag, msg)
        }
    }

    fun info(msg: Any) {
        info(DEFAULT_TAG, msg)
    }

    fun info(tag: String, msg: Any) {
        if (isShowLog) {
            printLog(Log.INFO, tag, msg)
        }
    }

    fun warn(msg: Any) {
        warn(DEFAULT_TAG, msg)
    }

    fun warn(tag: String, msg: Any) {
        if (isShowLog) {
            printLog(Log.WARN, tag, msg)
        }
    }

    fun error(msg: Any) {
        error(DEFAULT_TAG, msg)
    }

    fun error(tag: String, msg: Any) {
        if (isShowLog) {
            printLog(Log.ERROR, tag, msg)
        }
    }

    private fun printLog(type: Int, tag: String, msg: Any) {
        val log = msg.let {
            "[ $it ]"
        }.toString()
        when (type) {
            Log.VERBOSE -> Log.v(tag, log)
            Log.DEBUG -> Log.d(tag, log)
            Log.INFO -> Log.i(tag, log)
            Log.WARN -> Log.w(tag, log)
            Log.ERROR -> Log.e(tag, log)
        }
    }
}