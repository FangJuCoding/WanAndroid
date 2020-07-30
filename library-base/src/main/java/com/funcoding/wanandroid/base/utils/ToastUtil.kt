package com.funcoding.wanandroid.base.utils

import android.widget.Toast
import com.funcoding.wanandroid.base.base.BaseApplication

object ToastUtil {
    private val toast: Toast by lazy {
        Toast.makeText(BaseApplication.context, "", Toast.LENGTH_SHORT)
    }

    fun showShortToast(msg: String) {
        toast.duration = Toast.LENGTH_SHORT
        toast.setText(msg)
        toast.show()
    }

    fun showLongToast(msg: String) {
        toast.duration = Toast.LENGTH_LONG
        toast.setText(msg)
        toast.show()
    }
}