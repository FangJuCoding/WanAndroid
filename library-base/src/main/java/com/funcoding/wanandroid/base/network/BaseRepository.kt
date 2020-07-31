package com.funcoding.wanandroid.base.network

import androidx.lifecycle.liveData
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

abstract class BaseRepository {
    protected fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            emit(result)
        }
}