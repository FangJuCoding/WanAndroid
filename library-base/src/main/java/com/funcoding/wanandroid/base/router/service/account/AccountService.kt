package com.funcoding.wanandroid.base.router.service.account

import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.template.IProvider
import com.funcoding.wanandroid.base.global.model.UserInfo

/**
 * 其他模块获取账户信息的服务类
 */
interface AccountService : IProvider {
    fun isLogin(): Boolean

    fun getUserInfo(): UserInfo?

    fun logout()

    fun getUserInfoLiveData(): LiveData<UserInfo>

    fun isLoginLiveData(): LiveData<Boolean>
}