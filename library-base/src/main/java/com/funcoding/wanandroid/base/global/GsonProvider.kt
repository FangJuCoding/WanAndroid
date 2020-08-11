package com.funcoding.wanandroid.base.global

import com.google.gson.Gson

object GsonProvider {
    val gson: Gson by lazy { Gson() }
}