package com.funcoding.wanandroid.base.global

import android.content.Context
import com.funcoding.wanandroid.base.base.BaseApplication

object AccountManager {
    private const val pref_name = "account_manager"
    private const val pref_username = "account_username"
    private const val pref_password = "account_password"
    private const val pref_token = "account_token"
    private const val pref_isRememberPwd = "account_isRememberPwd"

    var username: String?
        get() = sharedPreferences().getString(pref_username, "")
        set(value) {
            sharedPreferences().edit().putString(pref_username, value).apply()
        }

    var password: String?
        get() = sharedPreferences().getString(pref_password, "")
        set(value) {
            sharedPreferences().edit().putString(pref_password, value).apply()
        }

    var token: String?
        get() = sharedPreferences().getString(pref_token, "")
        set(value) {
            sharedPreferences().edit().putString(pref_token, value).apply()
        }

    var isRememberPwd: Boolean
        get() = sharedPreferences().getBoolean(pref_isRememberPwd, false)
        set(value) {
            sharedPreferences().edit().putBoolean(pref_isRememberPwd, value).apply()
        }

    private fun sharedPreferences() =
        BaseApplication.context.getSharedPreferences(pref_name, Context.MODE_PRIVATE)
}