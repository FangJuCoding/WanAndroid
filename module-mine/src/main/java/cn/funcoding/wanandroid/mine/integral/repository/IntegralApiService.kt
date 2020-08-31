package cn.funcoding.wanandroid.mine.integral.repository

import cn.funcoding.wanandroid.base.global.model.Pagination
import cn.funcoding.wanandroid.base.network.ApiResponse
import cn.funcoding.wanandroid.mine.integral.model.IntegralRank
import cn.funcoding.wanandroid.mine.integral.model.IntegralRecord
import retrofit2.http.GET
import retrofit2.http.Path

interface IntegralApiService {
    /**
     * 获取个人积分
     */
    @GET("/lg/coin/userinfo/json")
    suspend fun getMyIntegral(): ApiResponse<IntegralRank>

    /**
     * 获取积分排行榜
     */
    @GET("/coin/rank/{page}/json")
    suspend fun getIntegralRank(@Path("page") page: Int): ApiResponse<Pagination<IntegralRank>>

    /**
     * 获取积分列表
     */
    @GET("/lg/coin/list/{page}/json")
    suspend fun getIntegralList(@Path("page") page: Int): ApiResponse<Pagination<IntegralRecord>>
}