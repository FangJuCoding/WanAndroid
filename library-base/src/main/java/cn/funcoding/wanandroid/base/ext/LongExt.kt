package cn.funcoding.wanandroid.base.ext

import java.text.SimpleDateFormat
import java.util.*

/**
 * 转换成时间格式
 */
fun Long.toDateTime(pattern: String): String =
    SimpleDateFormat(pattern, Locale.getDefault()).format(this)