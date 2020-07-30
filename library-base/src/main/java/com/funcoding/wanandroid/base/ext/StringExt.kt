package com.funcoding.wanandroid.base.ext

import com.funcoding.wanandroid.base.utils.ToastUtil

fun String.toast() {
    ToastUtil.showShortToast(this)
}

fun String.shortToast() {
    ToastUtil.showShortToast(this)
}

fun String.longToast() {
    ToastUtil.showLongToast(this)
}