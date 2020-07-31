package com.funcoding.wanandroid.user.account

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.funcoding.wanandroid.user.data.UserRepository
import com.funcoding.wanandroid.user.data.model.UserInfo

class AccountViewModel : ViewModel() {
    var username = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var isRememberPwd = MutableLiveData<Boolean>()

    var loginResult = MutableLiveData<Boolean>()

    private val userInfo = MutableLiveData<UserInfo>()

    var isLoading = MutableLiveData<Boolean>()

    fun login(username: String, password: String, rememberPwd: Boolean) {
        isLoading.value = true
        UserRepository.login(username, password)
    }
}