package cn.funcoding.wanandroid.mine.integral.record

import androidx.lifecycle.MutableLiveData
import cn.funcoding.wanandroid.base.base.BaseViewModel
import cn.funcoding.wanandroid.mine.integral.model.IntegralRank
import cn.funcoding.wanandroid.mine.integral.model.IntegralRecord
import cn.funcoding.wanandroid.mine.integral.repository.IntegralRepository

class IntegralRecordViewModel : BaseViewModel() {
    companion object {
        const val INITIAL_PAGE = 1
    }

    private val integralRepository by lazy { IntegralRepository() }

    // 我的积分
    val myIntegralRecord = MutableLiveData<IntegralRank>()

    // 积分列表
    val myIntegralRecordList = MutableLiveData<MutableList<IntegralRecord>>()

    // 当前页码
    var curPage = INITIAL_PAGE

    // 是否在刷新
    var isRefreshing = MutableLiveData<Boolean>()

    fun refresh() {
        isRefreshing.value = true
        launch(
            block = {
                val myIntegral = integralRepository.getMyIntegral()
                val pagination = integralRepository.getIntegralList(INITIAL_PAGE)
                curPage = pagination.curPage
                myIntegralRecord.value = myIntegral
                myIntegralRecordList.value = pagination.datas.toMutableList()
                isRefreshing.value = false
            },
            error = {
                isRefreshing.value = false
            }
        )
    }

    fun loadMoreRecord() {
        isRefreshing.value = true
        launch(
            block = {
                val pagination = integralRepository.getIntegralList(curPage)
                myIntegralRecordList.value = pagination.datas.toMutableList()
                isRefreshing.value = false
            },
            error = {
                isRefreshing.value = false
            }
        )
    }
}