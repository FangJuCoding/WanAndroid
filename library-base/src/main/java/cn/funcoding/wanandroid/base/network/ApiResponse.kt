package cn.funcoding.wanandroid.base.network

data class ApiResponse<out T>(
    private val data: T,
    private val errorCode: Int,
    private val errorMsg: String
) {
    fun apiData(): T {
        if (errorCode == 0) {
            return data
        } else {
            throw ApiException(errorCode, errorMsg)
        }
    }

    fun apiErrorCode(): Int {
        return errorCode
    }

    fun apiErrorMsg(): String {
        return errorMsg
    }
}