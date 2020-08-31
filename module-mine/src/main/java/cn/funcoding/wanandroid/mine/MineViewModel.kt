package cn.funcoding.wanandroid.mine

import androidx.lifecycle.MutableLiveData
import cn.funcoding.wanandroid.base.base.BaseViewModel
import cn.funcoding.wanandroid.base.global.model.UserInfo
import cn.funcoding.wanandroid.base.router.service.account.AccountServiceImplGlobal

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