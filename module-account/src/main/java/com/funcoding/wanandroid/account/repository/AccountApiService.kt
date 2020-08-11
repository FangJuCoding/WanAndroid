package com.funcoding.wanandroid.account.repository

import com.funcoding.wanandroid.base.network.ApiResponse
import com.funcoding.wanandroid.base.global.model.UserInfo
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * 用户相关的网络请求接口
 */
interface AccountApiService {
    @POST("/user/login")
    suspend fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): ApiResponse<UserInfo>

    @POST("/user/register")
    suspend fun register(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("repassword") rePassword: String
    ): ApiResponse<UserInfo>

    @GET("/user/logout/json")
    suspend fun logout(): ApiResponse<Any>
}