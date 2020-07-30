package com.funcoding.wanandroid.base.network

data class ApiResponse<out T>(val data: T, val errorCode: Int, val errorMsg: String) {
    fun apiData(): T {
        if (errorCode == 0) {
            return data
        } else {
            throw ApiException(errorCode, errorMsg)
        }
    }
}