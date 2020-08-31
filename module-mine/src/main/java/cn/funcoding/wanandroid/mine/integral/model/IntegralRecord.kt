package cn.funcoding.wanandroid.mine.integral.model

/**
 * 积分记录
 */
data class IntegralRecord(
    val coinCount: Int,
    val date: Long,
    val desc: String,
    val id: Long,
    val reason: String,
    val type: Int,
    val userId: Long,
    val userName: String
)