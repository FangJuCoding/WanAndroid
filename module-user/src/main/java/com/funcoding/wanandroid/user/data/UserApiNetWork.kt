package com.funcoding.wanandroid.user.data

import com.funcoding.wanandroid.base.network.BaseApiNetWork
import com.funcoding.wanandroid.base.network.ServiceCreator

object UserApiNetWork : BaseApiNetWork() {
    private val userApiService = ServiceCreator.create(UserApiService::class.java)

    suspend fun login(username: String, password: String) =
        userApiService.login(username, password).await()

    suspend fun register(username: String, password: String, rePassword: String) =
        userApiService.register(username, password, rePassword).await()
}