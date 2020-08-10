package com.funcoding.wanandroid.user.account

import androidx.lifecycle.MutableLiveData
import com.funcoding.wanandroid.base.base.BaseViewModel
import com.funcoding.wanandroid.base.global.AccountManager
import com.funcoding.wanandroid.user.account.data.AccountRepository

class AccountViewModel : BaseViewModel() {
    private val userRepository by lazy { AccountRepository }
    val isShowLoading = MutableLiveData<Boolean>()
    val loginResult = MutableLiveData<Boolean>()
    val registerResult = MutableLiveData<Boolean>()

    fun login(username: String, password: String, isRememberPwd: Boolean) {
        isShowLoading.value = true
        launch(
            block = {
                val userInfo = userRepository.login(username, password)
                AccountManager.username = userInfo.username
                AccountManager.password = password
                AccountManager.isRememberPwd = isRememberPwd
                AccountManager.isLoginSuccess = true
                isShowLoading.value = false
                loginResult.value = true
            },
            error = {
                AccountManager.isLoginSuccess = false
                isShowLoading.value = false
                loginResult.value = false
            }
        )
    }

    fun register(username: String, password: String, rePassword: String) {
        isShowLoading.value = true
        launch(
            block = {
                val userInfo = userRepository.register(username, password, rePassword)
                AccountManager.username = userInfo.username
                AccountManager.password = password
                AccountManager.isRememberPwd = true
                AccountManager.isLoginSuccess = true
                isShowLoading.value = false
                registerResult.value = true
            },
            cancel = {
                isShowLoading.value = false
                registerResult.value = false
            }
        )
    }

    fun getUsername(): String = AccountManager.username

    fun getPassword(): String = AccountManager.password

    fun isRememberPwd(): Boolean = AccountManager.isRememberPwd
}