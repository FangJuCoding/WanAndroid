package cn.funcoding.wanandroid.mine.integral.rank

import androidx.lifecycle.MutableLiveData
import cn.funcoding.wanandroid.base.base.BaseViewModel
import cn.funcoding.wanandroid.mine.integral.model.IntegralRank
import cn.funcoding.wanandroid.mine.integral.repository.IntegralRepository

class IntegralRankViewModel : BaseViewModel() {
    companion object {
        const val INITIAL_PAGE = 1
    }

    private val integralRepository by lazy { IntegralRepository() }

    // 积分排行列表
    var userIntegralRankList = MutableLiveData<MutableList<IntegralRank>>()

    // 当前页
    var curPage = INITIAL_PAGE

    var isRefreshing = MutableLiveData<Boolean>()

    fun refresh() {
        isRefreshing.value = true
        launch(
            block = {
                val integralRankList = integralRepository.getIntegralRank(INITIAL_PAGE)
                userIntegralRankList.value = integralRankList.datas.toMutableList()
                isRefreshing.value = false
            },
            error = {
                isRefreshing.value = false
            }
        )
    }
}