package cn.funcoding.wanandroid.account.service

import android.content.Context
import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.annotation.Route
import cn.funcoding.wanandroid.base.global.model.UserInfo
import cn.funcoding.wanandroid.base.router.service.ServicePath
import cn.funcoding.wanandroid.base.router.service.account.AccountService
import cn.funcoding.wanandroid.base.utils.WLog
import cn.funcoding.wanandroid.account.AccountManager
import cn.funcoding.wanandroid.account.repository.AccountRepository
import cn.funcoding.wanandroid.base.network.ServiceCreator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

@Route(path = ServicePath.ACCOUNT_SERVICE_PATH)
class AccountServiceImpl : AccountService {
    override fun isLogin(): Boolean = AccountManager.isLogin()

    override fun getUserInfo(): UserInfo? = AccountManager.getUserInfo()

    override fun logout() {
        CoroutineScope(Dispatchers.IO).async {
            AccountRepository.logout()
            ServiceCreator.clearCookie()
            AccountManager.logout()
        }
    }

    override fun getUserInfoLiveData(): LiveData<UserInfo> = AccountManager.getUserInfoLiveData()

    override fun isLoginLiveData(): LiveData<Boolean> = AccountManager.isLoginLiveData()

    override fun init(context: Context?) {
    }

}