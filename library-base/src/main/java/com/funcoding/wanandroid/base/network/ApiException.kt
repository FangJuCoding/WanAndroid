package com.funcoding.wanandroid.base.network

import java.lang.RuntimeException

data class ApiException(var code: Int, override val message: String) : RuntimeException()