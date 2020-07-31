package com.funcoding.wanandroid.user.data

import com.funcoding.wanandroid.base.global.AccountManager
import com.funcoding.wanandroid.base.network.ApiResponse
import com.funcoding.wanandroid.base.network.BaseRepository
import com.funcoding.wanandroid.user.data.model.UserInfo
import kotlinx.coroutines.Dispatchers

/**
 * 登陆注册模块数据仓库
 */
object UserRepository : BaseRepository() {
    fun getUsername() = AccountManager.username

    fun getPwd() = AccountManager.password

    fun getToken() = AccountManager.token

    fun isRememberPwd() = AccountManager.isRememberPwd

    fun login(username: String, password: String) = fire(Dispatchers.IO) {
        val loginResponse: ApiResponse<UserInfo> = UserApiNetWork.login(username, password)
        if (loginResponse.apiErrorCode() == 0) {
            Result.success(loginResponse.apiData())
        } else {
            Result.failure(RuntimeException("errorCode = ${loginResponse.apiErrorCode()} , errorMsg = ${loginResponse.apiErrorMsg()}"))
        }
    }
}