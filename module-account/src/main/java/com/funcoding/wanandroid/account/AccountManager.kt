package com.funcoding.wanandroid.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.funcoding.wanandroid.base.base.AppContext
import com.funcoding.wanandroid.base.ext.*
import com.funcoding.wanandroid.base.global.GsonProvider
import com.funcoding.wanandroid.base.global.model.UserInfo

object AccountManager {
    private const val pref_name = "account_manager"
    private const val pref_userInfo = "account_userInfo"
    private const val pref_username = "account_username"
    private const val pref_password = "account_password"
    private const val pref_isRememberPwd = "account_isRememberPwd"

    private val userInfoLiveData = MutableLiveData<UserInfo>()

    var username: String by Preferences(
        AppContext,
        pref_username, "",
        pref_name
    )

    var password: String by Preferences(
        AppContext,
        pref_password, "",
        pref_name
    )

    var isRememberPwd: Boolean by Preferences(
        AppContext,
        pref_isRememberPwd, true,
        pref_name
    )

    fun isLogin() = getUserInfo() != null

    fun logout() {
        password = ""
        isRememberPwd = true
        clearUserInfo()
    }

    fun getUserInfoLiveData(): LiveData<UserInfo> = userInfoLiveData

    fun getUserInfo(): UserInfo? {
        val userInfoStr = getSpValue(
            AppContext,
            pref_userInfo, "",
            pref_name
        )
        return userInfoStr.isNotEmpty().yes {
            GsonProvider.gson.fromJson(userInfoStr, UserInfo::class.java)
        }.otherwise {
            null
        }
    }

    fun saveUserInfo(userInfo: UserInfo) {
        putSpValue(
            AppContext,
            pref_userInfo, GsonProvider.gson.toJson(userInfo),
            pref_name
        )
        if (userInfoLiveData.hasObservers()) {
            userInfoLiveData.postValue(userInfo)
        }
    }


    fun clearUserInfo() {
        putSpValue(
            AppContext,
            pref_userInfo, "",
            pref_name
        )
        if (userInfoLiveData.hasObservers()) {
            userInfoLiveData.postValue(null)
        }
    }
}