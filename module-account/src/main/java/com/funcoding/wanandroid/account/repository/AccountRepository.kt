package com.funcoding.wanandroid.account.repository

import com.funcoding.wanandroid.base.network.ServiceCreator

/**
 * 登陆注册模块数据仓库
 */
object AccountRepository {
    private val userApiService by lazy {
        ServiceCreator.create(AccountApiService::class.java)
    }

    suspend fun login(username: String, password: String) =
        userApiService.login(username, password).apiData()

    suspend fun register(username: String, password: String, rePassword: String) =
        userApiService.register(username, password, rePassword).apiData()

    suspend fun logout() = userApiService.logout()
}