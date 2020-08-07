package com.funcoding.wanandroid.base.global

import com.funcoding.wanandroid.base.base.AppContext
import com.funcoding.wanandroid.base.ext.Preferences

object AccountManager {
    private const val pref_name = "account_manager"
    private const val pref_username = "account_username"
    private const val pref_password = "account_password"
    private const val pref_token = "account_token"
    private const val pref_isRememberPwd = "account_isRememberPwd"

    var username: String by Preferences(AppContext, pref_username, "", pref_name)

    var password: String by Preferences(AppContext, pref_password, "", pref_name)

    var token: String by Preferences(AppContext, pref_token, "", pref_name)

    var isRememberPwd: Boolean by Preferences(AppContext, pref_isRememberPwd, true, pref_name)
}