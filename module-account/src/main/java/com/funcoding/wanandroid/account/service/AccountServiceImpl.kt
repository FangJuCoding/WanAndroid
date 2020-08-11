package com.funcoding.wanandroid.account.service

import android.content.Context
import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.annotation.Route
import com.funcoding.wanandroid.base.global.model.UserInfo
import com.funcoding.wanandroid.base.router.service.ServicePath
import com.funcoding.wanandroid.base.router.service.account.AccountService
import com.funcoding.wanandroid.base.utils.WLog
import com.funcoding.wanandroid.account.AccountManager

@Route(path = ServicePath.ACCOUNT_SERVICE_PATH)
class AccountServiceImpl : AccountService {
    override fun isLogin(): Boolean = AccountManager.isLogin()

    override fun getUserInfo(): UserInfo? = AccountManager.getUserInfo()

    override fun logout() {
        WLog.info("logout")
        AccountManager.logout()
    }

    override fun getUserInfoLiveData(): LiveData<UserInfo> = AccountManager.getUserInfoLiveData()

    override fun init(context: Context?) {
    }

}