package com.funcoding.wanandroid.base.router.service.account

import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.funcoding.wanandroid.base.global.model.UserInfo
import com.funcoding.wanandroid.base.router.service.ServicePath

/**
 * AccountServiceImpl的代理类
 */
object AccountServiceImplGlobal {

    @Autowired(name = ServicePath.ACCOUNT_SERVICE_PATH)
    lateinit var accountService: AccountService

    init {
        ARouter.getInstance().inject(this)
    }

    fun isLogin(): Boolean = accountService.isLogin()

    fun getUserInfo(): UserInfo? = accountService.getUserInfo()

    fun logout() {
        accountService.logout()
    }

    fun getUserInfoLiveData(): LiveData<UserInfo> = accountService.getUserInfoLiveData()

    fun isLoginLiveData(): LiveData<Boolean> = accountService.isLoginLiveData()
}