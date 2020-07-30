package com.funcoding.wanandroid.user.account

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountViewModel : ViewModel() {
    var username = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var isRememberPwd = MutableLiveData<Boolean>()

    var loginResult = MutableLiveData<Boolean>()

    fun login(username: String, password: String, rememberPwd: Boolean) {

    }
}