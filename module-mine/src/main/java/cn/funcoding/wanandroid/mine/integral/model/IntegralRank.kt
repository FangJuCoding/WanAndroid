package cn.funcoding.wanandroid.mine.integral.model

/**
 * 积分排行（包括自己）
 */
data class IntegralRank(
    val coinCount: Int,
    val level: Int,
    val rank: String,
    val userId: Long,
    val username: String
)