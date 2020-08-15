package com.funcoding.wanandroid.mine.integral.repository

import com.funcoding.wanandroid.base.network.ServiceCreator

/**
 * 积分仓库
 */
class IntegralRepository {
    private val integralApiService by lazy { ServiceCreator.create(IntegralApiService::class.java) }

    suspend fun getMyIntegral() = integralApiService.getMyIntegral().apiData()

    suspend fun getIntegralRank(page: Int) = integralApiService.getIntegralRank(page).apiData()

    suspend fun getIntegralList(page: Int) = integralApiService.getIntegralList(page).apiData()
}