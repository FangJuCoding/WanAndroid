package com.funcoding.wanandroid.mine

import androidx.lifecycle.MutableLiveData
import com.funcoding.wanandroid.base.base.BaseViewModel
import com.funcoding.wanandroid.base.global.model.UserInfo
import com.funcoding.wanandroid.base.router.service.account.AccountServiceImplGlobal

class MineViewModel : BaseViewModel() {

    var userInfo = MutableLiveData<UserInfo>()

    var isLogin = MutableLiveData<Boolean>()

    fun refreshMineInfo() {
        userInfo.value = AccountServiceImplGlobal.getUserInfo()
        isLogin.value = AccountServiceImplGlobal.isLogin()
    }

    fun isLogin(): Boolean = AccountServiceImplGlobal.isLogin()

    fun logout() {
        AccountServiceImplGlobal.logout()
    }
}