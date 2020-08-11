package com.funcoding.wanandroid.mine

import androidx.lifecycle.MutableLiveData
import com.funcoding.wanandroid.base.base.BaseViewModel
import com.funcoding.wanandroid.base.global.model.UserInfo
import com.funcoding.wanandroid.base.router.service.account.AccountServiceImplGlobal

class MineViewModel : BaseViewModel() {

    var userInfo = MutableLiveData<UserInfo>()

    fun getUserInfo() {
        userInfo.value = AccountServiceImplGlobal.getUserInfo()
    }

    fun isLogin(): Boolean = AccountServiceImplGlobal.isLogin()

    fun logout() {
        AccountServiceImplGlobal.logout()
    }
}