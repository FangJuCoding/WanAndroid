package com.funcoding.wanandroid.base.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.funcoding.wanandroid.base.R
import com.funcoding.wanandroid.base.ext.shortToast
import com.funcoding.wanandroid.base.network.ApiException
import com.google.gson.JsonParseException
import kotlinx.coroutines.*
import java.net.ConnectException
import java.net.SocketTimeoutException

typealias Block<T> = suspend () -> T
typealias Error = suspend (e: Exception) -> Unit
typealias Cancel = suspend (e: Exception) -> Unit

open class BaseViewModel : ViewModel() {

    /**
     * 创建并执行协程
     */
    protected fun launch(block: Block<Unit>, error: Error? = null, cancel: Cancel? = null): Job {
        return viewModelScope.launch {
            try {
                block.invoke()
            } catch (e: Exception) {
                when (e) {
                    is CancellationException -> cancel?.invoke(e)
                    else -> {
                        onError(e)
                        error?.invoke(e)
                    }
                }
            }
        }
    }

    /**
     * 创建并执行协程
     */
    protected fun <T> async(block: Block<T>): Deferred<T> {
        return viewModelScope.async {
            block.invoke()
        }
    }

    /**
     * 取消协程
     */
    protected fun cancelJob(job: Job?) {
        if (job != null && job.isActive && !job.isCompleted && !job.isCancelled) {
            job.cancel()
        }
    }

    private fun onError(e: Exception) {
        when (e) {
            is ApiException -> {
                // API 请求错误
                when (e.code) {
                    -1 -> {
                        e.message.shortToast()
                    }
                    else -> {
                        e.message.shortToast()
                    }
                }
            }
            is ConnectException -> {
                // 网络连接失败
                AppContext.resources.getString(R.string.base_tip_network_connection_failed)
                    .shortToast()
            }
            is SocketTimeoutException -> {
                // 网络连接超时
                AppContext.resources.getString(R.string.base_tip_network_request_timeout)
                    .shortToast()
            }
            is JsonParseException -> {
                // 数据解析异常
                AppContext.resources.getString(R.string.base_tip_api_data_parse_error)
                    .shortToast()
            }
            else -> {
                // 其他错误
                e.message?.shortToast()
            }
        }
    }

}