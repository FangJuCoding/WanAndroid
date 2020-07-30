package com.funcoding.wanandroid.user.data

import com.funcoding.wanandroid.base.network.ApiResponse
import com.funcoding.wanandroid.user.data.model.UserInfo
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * 用户相关的网络请求接口
 */
interface UserApiService {
    @POST("/user/login")
    fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): Call<ApiResponse<UserInfo>>

    @POST("/user/register")
    fun register(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("repassword") rePassword: String
    ): Call<ApiResponse<UserInfo>>
}