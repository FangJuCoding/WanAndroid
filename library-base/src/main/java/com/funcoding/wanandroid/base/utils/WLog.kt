package com.funcoding.wanandroid.base.utils

import android.util.Log

class WLog {

    companion object {
        private const val TAG = "WLog"

        private var is_show_log = false

        fun init(isShowLog: Boolean) {
            is_show_log = isShowLog
        }

        fun verbose(msg: Any) {
            printLog(Log.VERBOSE, TAG, msg)
        }

        fun verbose(tag: String, msg: Any) {
            printLog(Log.VERBOSE, tag, msg)
        }

        fun debug(msg: Any) {
            printLog(Log.DEBUG, TAG, msg)
        }

        fun debug(tag: String, msg: Any) {
            printLog(Log.DEBUG, tag, msg)
        }

        fun info(msg: Any) {
            printLog(Log.INFO, TAG, msg)
        }

        fun info(tag: String, msg: Any) {
            printLog(Log.INFO, tag, msg)
        }

        fun warn(msg: Any) {
            printLog(Log.WARN, TAG, msg)
        }

        fun warn(tag: String, msg: Any) {
            printLog(Log.WARN, tag, msg)
        }

        fun error(msg: Any) {
            printLog(Log.ERROR, TAG, msg)
        }

        fun error(tag: String, msg: Any) {
            printLog(Log.ERROR, tag, msg)
        }

        private fun printLog(type: Int, tag: String, msg: Any) {
            val logStr = msg.let {
                "" + it
            }
            when (type) {
                Log.VERBOSE -> Log.v(tag, logStr)
                Log.DEBUG -> Log.d(tag, logStr)
                Log.INFO -> Log.i(tag, logStr)
                Log.WARN -> Log.w(tag, logStr)
                Log.ERROR -> Log.e(tag, logStr)
            }
        }
    }
}