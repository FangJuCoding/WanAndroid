package cn.funcoding.wanandroid.base.ext

import cn.funcoding.wanandroid.base.utils.ToastUtil

fun String.toast() {
    ToastUtil.showShortToast(this)
}

fun String.shortToast() {
    ToastUtil.showShortToast(this)
}

fun String.longToast() {
    ToastUtil.showLongToast(this)
}