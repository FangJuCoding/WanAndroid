package com.funcoding.wanandroid.base.global

import com.funcoding.wanandroid.base.base.AppContext
import com.funcoding.wanandroid.base.ext.Preferences
import com.funcoding.wanandroid.base.global.model.UserCard

object AccountManager {
    private const val pref_name = "account_manager"
    private const val pref_username = "account_username"
    private const val pref_password = "account_password"
    private const val pref_isRememberPwd = "account_isRememberPwd"
    private const val pref_isLoginSuccess = "account_isLoginSuccess"

    var username: String by Preferences(AppContext, pref_username, "", pref_name)

    var password: String by Preferences(AppContext, pref_password, "", pref_name)

    var isRememberPwd: Boolean by Preferences(AppContext, pref_isRememberPwd, true, pref_name)

    var isLoginSuccess: Boolean by Preferences(AppContext, pref_isLoginSuccess, false, pref_name)

    fun logout() {
        password = ""
        isRememberPwd = true
        isLoginSuccess = false
    }

    private lateinit var userCard: UserCard

    fun createUserCard(
        admin: Boolean = false,
        chapterTops: List<Any> = emptyList(),
        coinCount: Int,
        collectIds: MutableList<Int> = mutableListOf(),
        email: String,
        icon: String,
        id: Long,
        nickname: String,
        publicName: String,
        type: Int,
        username: String
    ) {
        userCard = UserCard(
            admin,
            chapterTops,
            coinCount,
            collectIds,
            email,
            icon,
            id,
            nickname,
            publicName,
            type,
            username
        )
        this.username = username
        this.password = password
    }

    fun getUserCard(): UserCard {
        return userCard
    }
}